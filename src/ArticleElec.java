import java.time.LocalDate;

public class ArticleElec extends Article {
    private double price;
    private LocalDate date;

    public ArticleElec(int id,String name, String description, double price, int quantity) {
        super(id,name, description, quantity,3);
        this.price = price;
        this.date = LocalDate.now().plusYears(1);
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return super.toString() + " Quantity: " + super.getQuantity() + " Price: " + this.price + " Date guarented: " + this.date;
    }
}
