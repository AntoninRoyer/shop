public class Article {
    private int id;
    private String name;
    private String description;
    private double quantity;
    private int category;

    public Article(int id,String name, String description, double quantity, int category) {
        if(name == null || description == null || quantity <= 0) throw new IllegalArgumentException("The name and the description must be not null and the quantity must be more than 0");
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() { 
        return id; 
    }

    public double getQuantity() { 
        return quantity; 
    }

    public void setDescritpion(String description) {
        this.description = description;
    }

    public void setQuantity(double quantity) { 
        this.quantity = quantity; 
    }

    public String toString() {
        return "Id: " + this.id +" Name: " + this.name + " Description: " + this.description;
    }

    public int getCategory() {
        return category;
    }
}
