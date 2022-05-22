package ua.hillel.task20;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Product> products = Arrays.asList(
                new Product("Book", 260, true),
                new Product("Toy", 500),
                new Product("Book", 150, true),
                new Product("Clothes", 850, true),
                new Product("Stationery", 25),
                new Product("Book", 100)
        );
        Catalogue catalogue = new Catalogue(products);

        System.out.println("***** category: Book, Price > 250 *****");
        List<Product> goodBooks = catalogue.getGoodBooks();
        for (Product book : goodBooks) {
            System.out.println(book);
        }

        System.out.println("***** category: Book, has discount: true *****");
        List<Product> discountBooks = catalogue.getDiscountBooks();
        for (Product book : discountBooks) {
            System.out.println(book);
        }

        System.out.println("***** category: Book, price: min *****");
        Product theCheapest = catalogue.getTheCheapestBook("Book");
        System.out.println(theCheapest);

        System.out.println("***** time: the latest 3 *****");
        List<Product> allProducts = catalogue.getProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
        List<Product> theLatest = catalogue.getTheLatest();
        for (Product product : theLatest) {
            System.out.println(product);
        }
    }
}
