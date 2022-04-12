package ua.hillel.task13.coffee.order;

import java.util.LinkedList;

public class CoffeeOrderBoard {
    private LinkedList<Order> list = new LinkedList<>();

    public void add(Order order) {
        list.addLast(order);
    }

    public Order deliver() {
        return list.pollFirst();
    }

    public Order deliver(int id) {
        for (Order order : list) {
            if (order.getId() == id) {
                list.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("=================");
        System.out.println("Num |        Name");
        for (Order order : list) {
            System.out.printf("%-4d|%12s%n", order.getId(), order.getName());
        }
    }
}
