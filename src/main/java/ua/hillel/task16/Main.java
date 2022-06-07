package ua.hillel.task16;

public class Main {
    public static void main(String[] args) {
        // SinglyLinkedList
        SinglyLinkedList<Integer> digits = new SinglyLinkedList<>();
        digits.add(1);
        digits.add(5);
        digits.add(8);
        System.out.println("***** SinglyLinkedList Iterator *****");
        CustomIterator<Integer> iterator = digits.iterator();
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
        System.out.println("***** DoublyLinkedList Iterator *****");
        iterateDoublyList(strings);
        System.out.println("***** DoublyLinkedList ReverseIterator *****");
        iterateReverseDoublyList(strings);
        System.out.println("***** remove *****");
        System.out.println(strings.remove(0));
        System.out.println(strings.remove(3));
        System.out.println(strings.remove(2));
        System.out.println(strings.remove(1));
        System.out.println(strings.remove(0));
        System.out.println("***** removeFirst & removeLast *****");
        strings.add("antelope");
        strings.add("bull");
        strings.add("camel");
        strings.removeFirst();
        strings.removeLast();
        System.out.println(strings.get(0));
    }

    private static <T> void iterateDoublyList(DoublyLinkedList<T> list) {
        CustomIterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static <T> void iterateReverseDoublyList(DoublyLinkedList<T> list) {
        CustomReverseIterator<T> reverseIterator = list.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}
