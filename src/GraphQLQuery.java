public interface GraphQLQuery <T> {
    String getQueryPayload();
    T parseResponse(String json);
}
