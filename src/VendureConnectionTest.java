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
    String defaultUrl = "http://default-url.ch";
    connection.resolveUrl(defaultUrl);
    String input = null;
    connection.resolveUrl(input);
    String result = connection.getUrl();
    assertEquals("http://default-url.ch", connection.getUrl());
  }

  @Test
  void returnCleanedUrl() {
    String input = "cli --url http://url.ch";
    connection.resolveUrl(input);
    String result = connection.getUrl();
    assertEquals("http://url.ch", result);
  }

  @Test
  void returnInputUrlOverStoredUrl() {
    String defaultUrl = "http://default-url.ch";
    connection.resolveUrl(defaultUrl);
    String input = "http://new-url.ch";
    connection.resolveUrl(input);
    String result = connection.getUrl();
    assertEquals("http://new-url.ch", connection.getUrl());
  }
}
