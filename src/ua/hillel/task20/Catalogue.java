package ua.hillel.task20;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalogue {
    private final List<Product> products;

    public Catalogue(List<Product> products) {
        this.products = products;
    }

    public List<Product> getGoodBooks() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK && p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getDiscountBooks() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK && p.isDiscounted())
                .map(p -> new Product(p.getCategory(), p.getPrice() * 0.9f, p.isDiscounted(), p.getDate()))
                .collect(Collectors.toList());
    }

    public Product getTheCheapestBook(ProductCategory category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new ProductNotFoundException("Продукт " + category + " не найден."));
    }

    public List<Product> getTheLatestProducts() {
        return products.stream()
                .sorted((p1, p2) -> p2.getDate().compareTo(p1.getDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public float getThisYearCheapBooks() {
        return products.stream()
                .filter(p -> p.getCategory() == ProductCategory.BOOK
                        && p.getDate().getYear() == LocalDate.now().getYear()
                        && p.getPrice() <= 75)
                .map(Product::getPrice)
                .reduce(0f, Float::sum);
    }

    public Map<ProductCategory, List<Product>> group(ProductCategory category) {
        return products.stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.groupingBy(Product::getCategory));
    }
}
