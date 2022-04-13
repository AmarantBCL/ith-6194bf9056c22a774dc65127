package ua.hillel.task13;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class LinkedListUtils {
    public static void addFirst(LinkedList<String> list, String str) {
        list.addFirst(str);
    }

    public static void addLast(LinkedList<String> list, String str) {
        list.addLast(str);
    }

    public static LinkedList<Integer> join(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> list = new LinkedList<>(list1);
        list.addAll(list2);
        return list;
    }

    public static void shuffle(LinkedList<String> list) {
        String[] array = list.toArray(new String[0]);
        arrayShuffle(array);
        iterateOver(array, list);
    }

    public static LinkedList<Integer> intersect(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> resultList = new LinkedList<>();
        for (Integer i : list1) {
            if (!resultList.contains(i) && list2.contains(i)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    private static void iterateOver(String[] arr, LinkedList<String> list) {
        ListIterator<String> it = list.listIterator();
        for (String str : arr) {
            it.next();
            it.set(str);
        }
    }

    private static void arrayShuffle(String[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = rand.nextInt(i + 1);
            String object = arr[index];
            arr[index] = arr[i];
            arr[i] = object;
        }
    }
}
