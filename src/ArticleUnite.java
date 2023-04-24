public class ArticleUnite extends Article {
    private double unitPrice;

    public ArticleUnite(int id,String name, String description, double unitPrice, int quantity) {
        super(id,name, description,quantity,1);
        this.unitPrice = unitPrice;
    }

    public double getUnitePrice() {
        return unitPrice;
    }

    public void setUnitePrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return super.toString() + " Quantity: " + super.getQuantity() + " Unit price: " + this.unitPrice;
    }
}