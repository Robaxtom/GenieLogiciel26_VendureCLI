public class Product {
    private String name;
    private int id;

    public Product(int id, String name){
        this.name = name;
        this.id = id;
    }

    public String getName(){return name;}
    public int getId() {return id;}
}