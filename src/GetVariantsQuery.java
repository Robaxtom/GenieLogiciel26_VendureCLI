import java.util.List;

public class GetVariantsQuery implements GraphQLQuery<List<Variant>> {
    @Override
    public String getQueryPayload() {
        return "query {\n"
                + "  product{\n"
                + "    variants{\n"
                + "      id\n"
                + "      name\n"
                + "      price\n"
                + "      sku\n"
                + "    }\n"
                + "  }\n"
                + "}";
    }

    @Override
    public List<Variant> parseResponse(String json) {
        return null;
    }
}