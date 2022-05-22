package ua.hillel.task20;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Catalogue {
    private final List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Catalogue(List<Product> products) {
        this.products = products;
    }

    public List<Product> getGoodBooks() {
        return products.stream()
                .filter(p -> p.getCategory().equals("Book") && p.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getDiscountBooks() {
        return products.stream()
                .filter(p -> p.getCategory().equals("Book") && p.isDiscounted())
                .map(p -> new Product("Book", p.getPrice() * 0.9f, true))
                .collect(Collectors.toList());
    }

    public Product getTheCheapestBook(String category) {
        Optional<Product> optional = products.stream()
                .filter(p -> p.getCategory().equals(category))
                .min((p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice())).stream()
                .findFirst();
        if (optional.isEmpty()) {
            throw new ProductNotFoundException("Продукт " + category + " не найден.");
        }
        return optional.get();
    }

    public List<Product> getTheLatest() {
        return products.stream()
                .sorted((p1, p2) -> p2.getTime().compareTo(p1.getTime()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
