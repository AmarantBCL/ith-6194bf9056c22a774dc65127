package ua.hillel.task20;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Product> products = Arrays.asList(
                new Product(ProductCategory.BOOK, 70, false, LocalDate.of(2021, 11, 24)),
                new Product(ProductCategory.TOY, 475, true, LocalDate.of(2021, 12, 12)),
                new Product(ProductCategory.CLOTHES, 300, false, LocalDate.of(2021, 12, 20)),
                new Product(ProductCategory.BOOK, 50, true, LocalDate.of(2022, 1, 10)),
                new Product(ProductCategory.BOOK, 260, true, LocalDate.of(2022, 1, 28)),
                new Product(ProductCategory.TOY, 500, false, LocalDate.of(2022, 2, 16)),
                new Product(ProductCategory.CLOTHES, 850, true, LocalDate.of(2022, 3, 22)),
                new Product(ProductCategory.STATIONERY, 25, true, LocalDate.of(2022, 4, 11)),
                new Product(ProductCategory.BOOK, 100, false, LocalDate.of(2022, 5, 3)),
                new Product(ProductCategory.BOOK, 65, false, LocalDate.of(2022, 5, 23))
        );
        Catalogue catalogue = new Catalogue(products);

        System.out.println("***** Category: Book, Price > 250 *****");
        List<Product> goodBooks = catalogue.getGoodBooks();
        for (Product book : goodBooks) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("***** Category: Book, Has discount: true *****");
        List<Product> discountBooks = catalogue.getDiscountBooks();
        for (Product book : discountBooks) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("***** Category: Book, Price: min *****");
        Product theCheapest = catalogue.getTheCheapestBook(ProductCategory.BOOK);
        System.out.println(theCheapest);
        System.out.println();

        System.out.println("***** Date: the latest 3 *****");
        List<Product> theLatest = catalogue.getTheLatestProducts();
        for (Product product : theLatest) {
            System.out.println(product);
        }
        System.out.println();

        System.out.println("***** Calculate cost -> Category: Book, Date: this year, Price <= 75 *****");
        float calculatedBooks = catalogue.getThisYearCheapBooks();
        System.out.println(calculatedBooks);
        System.out.println();

        System.out.println("***** Grouping by category: TOY *****");
        Map<ProductCategory, List<Product>> group = catalogue.group(ProductCategory.TOY);
        System.out.println(group.keySet());
        for (List<Product> prods : group.values()) {
            System.out.println(prods);
        }
    }
}
