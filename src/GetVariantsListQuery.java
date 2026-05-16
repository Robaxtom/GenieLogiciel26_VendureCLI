import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class GetVariantsListQuery implements GraphQLQuery<List<Variant>> {
  @Override
  public String getQueryPayload() {
    return """
            query {
              products{
              items{
                variants{
                  id
                  name
                  price
                  sku
                   }
                 }
              }
            }""";
  }

  @Override
  public List<Variant> parseResponse(String json) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode itemsNode = mapper.readTree(json).path("data").path("products").path("items");

      List<Variant> variants = new ArrayList<>();
      for (JsonNode itemNode : itemsNode) {
        JsonNode variantsNode = itemNode.path("variants");
        for (JsonNode variant : variantsNode) {
          variants.add(
              new Variant(
                  variant.path("id").asInt(),
                  variant.path("name").asText(),
                  variant.path("price").asDouble(),
                  variant.path("sku").asText()));
        }
      }
      return variants;
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }
}
