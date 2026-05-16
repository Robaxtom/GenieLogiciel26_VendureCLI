import java.util.List;

public class ListVariantsCommand extends CommandStrategy {

  @Override
  void execute(VendureConnection vendureConnection, OutputStrategy outputStrategy) {
    GraphQLQuery<List<Variant>> query = new GetVariantsListQuery();
    VendureService service = new VendureService();
    List<Variant> variants = service.execute(query, vendureConnection);
    if (variants == null || variants.isEmpty()) {
      System.out.println("No variants were found!");
      return;
    }
    outputStrategy.display(variants);
  }
}
