package ua.hillel.task13;

import ua.hillel.task13.coffee.order.CoffeeOrderBoard;
import ua.hillel.task13.coffee.order.Order;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("middle");
        LinkedListUtils.addFirst(testList, "first");
        LinkedListUtils.addLast(testList, "last");
        System.out.println(testList);

        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(6, 7, 8, 9, 10));
        System.out.println(LinkedListUtils.join(list1, list2));

        LinkedList<String> allies = new LinkedList<>(Arrays.asList("Ukraine", "Great Britain", "Poland",
                "Czech Republic", "Slovakia", "USA", "France", "Germany", "Italy", "Spain", "Sweden",
                "Finland", "Denmark", "Austria", "Switzerland", "Croatia", "Slovenia", "Canada",
                "Japan", "Australia")
        );
        System.out.println(allies);
        LinkedListUtils.shuffle(allies);
        System.out.println(allies);
        LinkedListUtils.shuffle(allies);
        System.out.println(allies);
        LinkedListUtils.shuffle(allies);
        System.out.println(allies);

        LinkedList<Integer> ints1 = new LinkedList<>(Arrays.asList(1, 2, 3));
        LinkedList<Integer> ints2 = new LinkedList<>(Arrays.asList(3, 2, 5, 7));
        System.out.println(LinkedListUtils.intersect(ints1, ints2));

        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Order order1 = new Order("Vadym");
        Order order2 = new Order("Alyona");
        Order order3 = new Order("Kostya");
        board.add(order1);
        board.add(order2);
        board.add(order3);
        board.draw();
        board.deliver();
        board.draw();
        board.deliver(2);
        board.draw();
        Order order4 = new Order("Vika");
        Order order5 = new Order("Petya");
        board.add(order4);
        board.add(order5);
        board.draw();
        board.deliver();
        board.draw();
        board.deliver();
        board.draw();
        board.deliver();
        board.draw();
    }
}
