public class ArticlePoids extends Article {
    private double priceKg;

    public ArticlePoids(int id,String name, String description, double priceKg, int quantity) {
        super(id,name, description,quantity,2);
        this.priceKg = priceKg;
    }

    public double getPriceKg() {
        return priceKg;
    }

    public void setPriceKg(double priceKg) {
        this.priceKg = priceKg;
    }

    public String toString() {
        return super.toString() + " Weight: "+ super.getQuantity() + " Price per kg: " + this.priceKg;
    }
}
    
