import com.fasterxml.jackson.annotation.JsonIgnore;

public class Variant implements Tabulatable{
    private int id;
    private String name;
    private double price;
    private String sku;

    public Variant( int id, String name, double price, String sku){
        this.name = name;
        this.price = price;
        this.id = id;
        this.sku = sku;
    }

    public String getName(){return name;}
    public double getPrice() {return price;}
    public int getId() {return id;}

    @Override
    @JsonIgnore
    public String[] getHeaders() {
        return new String[]{"ID", "NAME", "PRICE", "SKU"};
    }

    @Override
    @JsonIgnore
    public String[] getValues() {
        return new String[]{String.valueOf(id), name, String.valueOf(price), String.valueOf(sku)};
    }
}