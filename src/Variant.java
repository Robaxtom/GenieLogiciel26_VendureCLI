public class Variant {
    private String name;
    private String description;
    private double price;
    private int id;

    public Variant(String name, double price, int id, String description){
        this.name = name;
        this.price = price;
        this.id = id;
        this.description = description;
    }

    public String getName(){return name;}
    public double getPrice() {return price;}
    public int getId() {return id;}
    public String getDescription(){ return description;}
}