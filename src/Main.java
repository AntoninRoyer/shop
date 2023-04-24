import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: Create a basket and a store
        Basket basket = new Basket();
        Store store = new Store();

        // TODO: Add some articles to the store
        String[] fruitsAndVegetables = {"pomme", "orange", "banane", "kiwi", "fraise"};
        String[] objects = {"vélo", "tente", "chaussures de randonnée", "ballon de foot", "livre"};
        String[] electronicsObjects = {"ordinateur portable", "téléphone portable", "tablette", "télévision", "enceinte bluetooth"};
        int id = 1;
        for (int i = 0; i < 3; i++) {
            ArticleElec article = new ArticleElec(id,electronicsObjects[i], "description of electrinics objects " + id, 1000, 1);
            store.addArticle(article);
            id++;
        }
        for (int i = 0; i < 3; i++) {
            ArticleUnite article = new ArticleUnite(id,objects[i], "description of unite object " + id, 1000, 1);
            store.addArticle(article);
            id++;
        }
        for (int i = 0; i < 3; i++) {
            ArticlePoids article = new ArticlePoids(id,fruitsAndVegetables[i], "description of weight object " + id, 1000, 1);
            store.addArticle(article);
            id++;
        }
        // Say hello
        System.out.println("Bienvenue dans notre magasin !");
        // Display menu
        System.out.println("1. Afficher les articles");
        System.out.println("2. Ajouter un article au panier");
        System.out.println("3. Afficher le panier");
        System.out.println("4. Supprimer un article du panier");
        System.out.println("5. Vider le panier");
        System.out.println("6. Valider le panier");
        System.out.println("7. Quitter");
        System.out.println("8. Afficher le menu à nouveau");
        // Create scanner
        Scanner scanner = new Scanner(System.in);
        // Loop until user quit
        boolean quit = false;
        while (!quit) {
            // Ask user to choose an option
            System.out.println("Choisissez une option :");
            int option = scanner.nextInt();
            // Switch on option
            switch (option) {
                case 1 ->{
                    // Display all articles
                    store.printArticles();
                    break;
                }
                case 2 -> {
                    // Ask user to choose an article
                    System.out.println("Choisissez un article avec son index:");
                    int articleId = scanner.nextInt();
                    System.out.println("Vous avez choisi l'article : " + store.getArticleById(articleId).getName());
                    // si l'article est au poids
                    if (store.getArticles().get(articleId) instanceof ArticlePoids) {
                        System.out.println("Entrez le poids souhaité (kg) :");
                    }
                    else {
                        System.out.println("Entrez la quantité souhaitée :");
                    }
                    double quantity = scanner.nextDouble();

                    // Add article to basket
                    for (Article article : store.getArticles()) {
                        if (article.getId() == articleId) {
                            article.setQuantity(quantity);
                            basket.addArticle(article, quantity);
                        }
                    }
                    System.out.println("Article ajouté au panier !");
                    
                    // Display menu
                    System.out.println("1. Afficher les articles");
                    System.out.println("2. Ajouter un article au panier");
                    System.out.println("3. Afficher le panier");
                    System.out.println("4. Supprimer un article du panier");
                    System.out.println("5. Vider le panier");
                    System.out.println("6. Valider le panier");
                    System.out.println("7. Quitter");
                    System.out.println("8. Afficher le menu à nouveau");
                    break;
                }
                case 3 ->{
                        // Display basket
                        System.out.println(basket.showBasket());
                        System.out.println("Prix total : " + basket.showTotalPrice() + " euros");
                        break;
                    }
                case 4 -> {
                    // Ask user to choose an article
                    System.out.println("Choisissez un article :");
                    int articleId = scanner.nextInt();
                    // Remove article from basket
                    basket.removeArticle(basket.getArticle(articleId));
                }
                case 5 -> {
                    // Empty basket
                    basket.getArticles().clear();
                    break;
                }
                case 6 -> {// Validate basket
                    basket.validateBasket();
                    break;
                }
                case 7 ->{
                    // Quit
                    quit = true;
                    break;
                }
                case 8 -> {
                    // Say hello
                    System.out.println("Bienvenue dans notre magasin !");
                    // Display menu
                    System.out.println("1. Afficher les articles");
                    System.out.println("2. Ajouter un article au panier");
                    System.out.println("3. Afficher le panier");
                    System.out.println("4. Supprimer un article du panier");
                    System.out.println("5. Vider le panier");
                    System.out.println("6. Valider le panier");
                    System.out.println("7. Quitter");
                    System.out.println("8. Afficher le menu à nouveau");
                    break;
                }
            }
        }
    }
}