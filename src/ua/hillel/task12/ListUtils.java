package ua.hillel.task12;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static int countOccurrence(List<String> list, String str) {
        int count = 0;
        for (String s : list) {
            if (str.equals(s)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        for (Integer i : list) {
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            } else {
                duplicates.add(i);
            }
        }
        for (Integer duplicate : duplicates) {
            if (uniqueList.contains(duplicate)) {
                uniqueList.remove(duplicate);
            }
        }
        return uniqueList;
    }

    public static void calcOccurrence(List<String> list) {
        List<String> tempList = new ArrayList<>();
        for (String animal : list) {
            if (!tempList.contains(animal)) {
                System.out.printf("%s: %d%n", animal, countOccurrence(list, animal));
                tempList.add(animal);
            }
        }
    }

    public static List<String> findOccurrence(List<String> list) {
        List<String> tempList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        for (String animal : list) {
            if (!tempList.contains(animal)) {
                String str = String.format("{name: \"%s\", occurrence: %d}",
                        animal, countOccurrence(list, animal));
                resultList.add(str);
                tempList.add(animal);
            }
        }
        return resultList;
    }
}
