import java.util.ArrayList;

public class Basket {
    private ArrayList<Object[]> articles;

    public Basket() {
        this.articles = new ArrayList<Object[]>();
    }

    public Article getArticle(int id) {
        for (Object[] article : articles) {
            if(((Article) article[0]).getId() == id) return (Article) article[0];
        }
        return null;
    }

    public ArrayList<Object[]> getArticles() {
        return articles;
    }

    public void addArticle(Article article, double quantity) {
        for (Object[] article2 : articles) {
            if(article == article2[0]) {
                System.out.println("Article already exists");
                return;
            }
        }
        Object[] article2 = {article, quantity};
        this.articles.add(article2);     
    }

    public void removeArticle(Article article) {
        for (Object[] article2 : articles) {
            if(article == article2[0]) {
                this.articles.remove(article2);
                return;
            }
        }
        System.out.println("Article doesn't exist");
    }

    public String showBasket() {
        String result = "";
        for (Object[] article : articles) {
            if(((Article) article[0]).getCategory() == 1) result += "Id: " + ((Article) article[0]).getId() + " Name: " + ((Article) article[0]).getName() + " Quantity: " + article[1] + " Price: " + ((ArticleUnite) article[0]).getUnitePrice()*((ArticleUnite) article[0]).getQuantity() + "\n";
        }
        for (Object[] article : articles) {
            if(((Article) article[0]).getCategory() == 2) result += "Id: " + ((Article) article[0]).getId() + " Name: " + ((Article) article[0]).getName() + " Weight: " + article[1] + " Price: " + ((ArticlePoids) article[0]).getPriceKg()*((ArticlePoids) article[0]).getQuantity() + "\n";
        }
        for (Object[] article : articles) {
            if(((Article) article[0]).getCategory() == 3) result += "Id: " + ((Article) article[0]).getId() + " Name: " + ((Article) article[0]).getName() + " Quantity: " + article[1] + " Price: " + ((ArticleElec) article[0]).getPrice()*((ArticleElec) article[0]).getQuantity() + "\n";
        }
        if(result == "") return ("Basket is empty");
        return result;
    }

    public double showTotalPrice(){
        double totalPrice = 0;
        for (Object[] article : articles) {
            if(((Article) article[0]).getCategory() == 1) totalPrice += ((ArticleUnite) article[0]).getUnitePrice() * (double) article[1];
        }
        for (Object[] article : articles) {
            if(((Article) article[0]).getCategory() == 2) totalPrice += ((ArticlePoids) article[0]).getPriceKg() * (double) article[1];
        }
        for (Object[] article : articles) {
            if(((Article) article[0]).getCategory() == 3) totalPrice += ((ArticleElec) article[0]).getPrice() * (double) article[1];
        }
        return totalPrice;
    }

    public void emptyBasket() {
        this.articles.clear();
    }

    public String validateBasket() {
        String result = "";
        for(Object[] article : articles) {
            if(article[0] instanceof ArticleUnite) {
                if(((ArticleUnite) article[0]).getQuantity() < (double) article[1]) {
                    result += "Not enough " + ((ArticleUnite) article[0]).getName() + "\n";
                }
                else {
                    ((ArticleUnite) article[0]).setQuantity(((ArticleUnite) article[0]).getQuantity() - (double) article[1]);
                    result += "Article " + ((ArticleUnite) article[0]).getName() + " bought\n";
                }
            }
            if (article[0] instanceof ArticlePoids) {
                if(((ArticlePoids) article[0]).getQuantity() < (double) article[1]) {
                    result += "Not enough " + ((ArticlePoids) article[0]).getName() + "\n";
                }
                else {
                    ((ArticlePoids) article[0]).setQuantity(((ArticlePoids) article[0]).getQuantity() - (double) article[1]);
                    result += "Article " + ((ArticlePoids) article[0]).getName() + " bought\n";
                }
            }
            if(article[0] instanceof ArticleElec) {
                if(((ArticleElec) article[0]).getQuantity() < (double) article[1]) {
                    result += "Not enough " + ((ArticleElec) article[0]).getName() + "\n";
                }
                else {
                    ((ArticleElec) article[0]).setQuantity(((ArticleElec) article[0]).getQuantity() - (double) article[1]);
                    result += "Article " + ((ArticleElec) article[0]).getName() + " bought\n";
                }
            }
        }
        articles.clear();
        return result;
    }
}
