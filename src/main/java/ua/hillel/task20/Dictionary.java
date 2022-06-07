package ua.hillel.task20;

import java.util.List;
import java.util.Map;

public class Dictionary {
    private final Map<ProductCategory, List<Product>> products;

    public Dictionary(Map<ProductCategory, List<Product>> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Dictionary{" + '\n' +
                "products=" + products + '\n' +
                '}';
    }
}
