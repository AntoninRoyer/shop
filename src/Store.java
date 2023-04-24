import java.util.ArrayList;

public class Store {
    private ArrayList<Article> articles;
    
    public Store() {
        this.articles = new ArrayList<Article>();
    }

    public void addArticle(Article addedArticle) {
        for (Article article : articles) {
            if(addedArticle.getName() == article.getName()) {
                System.out.println("this name already exists");
                return;
            }
            else if (addedArticle.getDescription() == article.getDescription()) {
                System.out.println("this description already exists");
                return;
            }
        }
        this.articles.add(addedArticle);
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    public void printArticles() {
        for(Article article : this.articles) {
            System.out.println(article.toString());
        }
    }

    public void addStock (Article article, int quantity) {
        for (Article article2 : articles) {
            if(article2.getName() == article.getName()) article2.setQuantity(article2.getQuantity() + quantity);
        }
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public Article getArticleById(int id) {
        for (Article article : articles) {
            if(article.getId() == id) return article;
        }
        return null;
    }
}
