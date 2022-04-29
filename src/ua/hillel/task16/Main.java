package ua.hillel.task16;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // SinglyLinkedList
        SinglyLinkedList<Integer> digits = new SinglyLinkedList<>();
        digits.add(1);
        digits.add(5);
        digits.add(8);
        System.out.println("***** SinglyLinkedList Iterator *****");
        Iterator<Integer> iterator = digits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // DoublyLinkedList
        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        System.out.println("***** size *****");
        System.out.println("Size: " + strings.size());
        System.out.println("***** add & get *****");
        strings.add("cat");
        strings.add("dog");
        strings.add("zebra");
        strings.add("elephant");
        strings.add("tiger");
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));
        System.out.println(strings.get(2));
        System.out.println(strings.get(3));
        System.out.println(strings.get(4));
        System.out.println("***** remove *****");
        System.out.println(strings.remove(2));
        printDoublyLinkedList(strings);
    }

    private static <T> void printDoublyLinkedList(DoublyLinkedList<T> list) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
