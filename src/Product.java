import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product implements Tabulatable {
  private String name;
  private int id;

  public Product(int id, String name) {
    this.name = name;
    this.id = id;
  }

  @Override
  public String toString() {
    return "Product [id= " + id + " | name = " + name + "]";
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
  @JsonIgnore
  public String[] getHeaders() {
    return new String[] {"ID", "NAME"};
  }

  @Override
  @JsonIgnore
  public String[] getValues() {
    return new String[] {String.valueOf(id), name};
  }
}
