package ua.hillel.task13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> testList = new LinkedList<>();
        LinkedListUtils.addFirst(testList, "first");
        LinkedListUtils.addLast(testList, "last");
        System.out.println(testList);

        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(6, 7, 8, 9, 10));
        System.out.println(LinkedListUtils.join(list1, list2));

        LinkedList<String> allies = new LinkedList<>(Arrays.asList("Ukraine", "Great Britain", "Poland",
                "Czech Republic", "Slovakia", "USA", "France", "Germany", "Italy", "Spain", "Sweden",
                "Finland", "Denmark", "Austria", "Switzerland", "Croatia", "Slovenia", "Canada",
                "Japan", "Australia"));
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
    }
}
