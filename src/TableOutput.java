import java.util.List;

public class TableOutput extends OutputStrategy {

  @Override
  void display(List<?> items) {
    if (items.get(0) instanceof Tabulatable) {
      Tabulatable first = (Tabulatable) items.get(0);
      String[] headers = first.getHeaders();
      String headerLine = String.join(" | ", headers);
      System.out.println(headerLine);
      int lineLength = headerLine.length();
      for (int k = 0; k < lineLength; k++) {
        System.out.print("-");
      }
      System.out.println();
      for (Object o : items) {
        Tabulatable row = (Tabulatable) o;
        System.out.println(String.join(" | ", row.getValues()));
      }
    } else {
      for (Object o : items) {
        System.out.println(o);
      }
    }
  }
}
