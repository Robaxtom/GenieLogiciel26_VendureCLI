import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class GetProductsListQuery implements GraphQLQuery<List<Product>> {
  @Override
  public String getQueryPayload() {
    return """
            query {
              products{
                items{
                  id
                  name
                }
              }
            }""";
  }

  @Override
  public List<Product> parseResponse(String json) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode itemsNode = mapper.readTree(json).path("data").path("products").path("items");

      List<Product> products = new ArrayList<>();
      for (JsonNode node : itemsNode) {
        products.add(new Product(node.path("id").asInt(), node.path("name").asText()));
      }
      return products;
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }
}
