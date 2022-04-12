package ua.hillel.task13.coffee.order;

public class Order {
    private static int totalOrders;
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Order(String name) {
        this.name = name;
        this.id = totalOrders;
        totalOrders++;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
