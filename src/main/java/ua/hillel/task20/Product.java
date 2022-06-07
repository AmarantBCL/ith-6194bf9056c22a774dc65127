package ua.hillel.task20;

import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private static final int DISCOUNT = 10;

    private final ProductCategory category;
    private float price;
    private boolean isDiscounted;
    private final LocalDate date;
    private final UUID id;

    public ProductCategory getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public LocalDate getDate() {
        return date;
    }

    public Product(ProductCategory category, float price, boolean isDiscounted, LocalDate date) {
        this.category = category;
        this.price = price;
        this.isDiscounted = isDiscounted;
        this.date = date;
        id = UUID.randomUUID();
    }

    public void applyDiscount() {
        price -= price * DISCOUNT / 100;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", price=" + price +
                ", isDiscounted=" + isDiscounted +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
