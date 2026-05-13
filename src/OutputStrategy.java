import java.util.List;

public abstract class OutputStrategy {
  private VendureConnection vendureConnection;

  abstract void display(List<?> items);
}
