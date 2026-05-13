import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VendureConnection {
  private String url;
  private final HttpClient client = HttpClient.newHttpClient();

  public VendureConnection() {}

  public void resolveUrl(String s) {
      if (s != null){
          this.url = s;
      } else {
          this.url = System.getenv("URL");
      }
  }

  public String getUrl() {
    return url;
  }

    public String executeQuery(String graphqlQuery) {
        try {
            String jsonPayload = "{\"query\": \"" + graphqlQuery.replace("\n", " ").replace("\"", "\\\"") + "\"}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
