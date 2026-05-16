import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VendureConnectionTest {

  private VendureConnection connection;

  @BeforeEach
  public void init() {
    connection = new VendureConnection();
  }

  @Test
  void returnCorrectUrl() {
    String input = "http://localhost:3000";
    connection.resolveUrl(input);
    String result = connection.getUrl();
    assertEquals("http://localhost:3000", result);
  }

  @Test
  void returnDefaultWhenNoneProvided() {
    // Default URL is set to http://localhost:3000/shop-api
    String input = null;
    connection.resolveUrl(input);
    String result = connection.getUrl();
    assertEquals("http://localhost:3000/shop-api", result);
  }

  @Test
  void returnInputUrlOverStoredUrl() {
    String defaultUrl = "http://default-url.ch";
    connection.resolveUrl(defaultUrl);
    String input = "http://new-url.ch";
    connection.resolveUrl(input);
    String result = connection.getUrl();
    assertEquals("http://new-url.ch", result);
  }
}
