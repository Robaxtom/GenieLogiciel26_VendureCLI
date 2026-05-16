import java.util.List;

public class ListCommand extends CommandStrategy {

  @Override
  void execute(VendureConnection vendureConnection, OutputStrategy outputStrategy) {
        GraphQLQuery<List<Product>> query = new GetProductsListQuery();
        VendureService service = new VendureService();
        List<Product> products = service.execute(query, vendureConnection);
        if (products == null || products.isEmpty()){
      System.out.println("No products were found!");
      return;
        }
        outputStrategy.display(products);
  }
}
