public class VendureService {

  public <T> T execute(GraphQLQuery<T> query, VendureConnection connection) {
    String payLoad = query.getQueryPayload();
    String response = connection.executeQuery(payLoad);
    return query.parseResponse(response);
  }
}
