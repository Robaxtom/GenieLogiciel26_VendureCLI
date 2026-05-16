import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphQLQueryTest {
  private GetProductsListQuery productsListQuery;
  private GetVariantsListQuery variantsListQuery;

  @BeforeEach
  public void init() {
    productsListQuery = new GetProductsListQuery();
    variantsListQuery = new GetVariantsListQuery();
  }

  @Test
  void QueryProductsList() {
    String payload = productsListQuery.getQueryPayload();
    assertNotNull(payload);
    assertTrue(payload.contains("query"));
    assertTrue(payload.contains("products"));
    assertTrue(payload.contains("items"));
    assertTrue(payload.contains("id"));
    assertTrue(payload.contains("name"));
  }

  @Test
  void QueryVariantsList() {
    String payload = variantsListQuery.getQueryPayload();
    assertNotNull(payload);
    assertTrue(payload.contains("query"));
    assertTrue(payload.contains("products"));
    assertTrue(payload.contains("items"));
    assertTrue(payload.contains("variants"));
    assertTrue(payload.contains("id"));
    assertTrue(payload.contains("name"));
    assertTrue(payload.contains("price"));
    assertTrue(payload.contains("sku"));
  }

  @Test
    void GetProductsListQueryParseJSON(){
      String mockJson = """
              {
                "data": {
                  "products": {
                    "items": [
                      {
                        "id": "1",
                        "name": "Laptop"
                      },
                      {
                        "id": "2",
                        "name": "Tablet"
                      },
                      {
                        "id": "3",
                        "name": "Wireless Optical Mouse"
              }
                    ]
                  }
                }
              }""";

      List<Product> products = productsListQuery.parseResponse(mockJson);
      assertNotNull(products);
      Product firstProduct = products.getFirst();
      assertInstanceOf(Product.class, firstProduct);
      assertEquals(3, products.size());
      assertEquals(1, firstProduct.getId());
      assertEquals("Laptop", firstProduct.getName());
  }

  @Test
    void GetVariantsListQueryParseJSON(){
      String mockJson = """
              {
                "data": {
                  "products": {
                    "items": [
                      {
                        "variants": [
                          {
                            "id": "1",
                            "name": "Laptop 13 inch 8GB",
                            "price": 129900,
                            "sku": "L2201308"
                          },
                          {
                            "id": "2",
                            "name": "Laptop 15 inch 8GB",
                            "price": 139900,
                            "sku": "L2201508"
                          },
                          {
                            "id": "3",
                            "name": "Laptop 13 inch 16GB",
                            "price": 219900,
                            "sku": "L2201316"
              }
                        ]
                      }
                    ]
                  }
                }
              }""";
      List<Variant> variants = variantsListQuery.parseResponse(mockJson);
      assertNotNull(variants);
      Variant firstVariant = variants.getFirst();
      assertInstanceOf(Variant.class, firstVariant);
      assertEquals(1, firstVariant.getId());
      assertEquals("Laptop 13 inch 8GB", firstVariant.getName());
      assertEquals(129900, firstVariant.getPrice());
      assertEquals("L2201308", firstVariant.getSku());
  }
}
