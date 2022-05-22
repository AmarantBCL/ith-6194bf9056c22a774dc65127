package ua.hillel.task20;

import java.time.LocalDateTime;

public class Product {
    private final String category;
    private float price;
    private boolean isDiscounted;
    private LocalDateTime dateTime;

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public LocalDateTime getTime() {
        return dateTime;
    }

    public Product(String category, float price) {
        this.category = category;
        this.price = price;
        dateTime = LocalDateTime.now();
    }

    public Product(String category, float price, boolean isDiscounted) {
        this(category, price);
        this.isDiscounted = isDiscounted;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", isDiscounted=" + isDiscounted +
                ", dateTime=" + dateTime +
                '}';
    }
}
