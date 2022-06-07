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
        List<Integer> resultList = new ArrayList<>();
        for (Integer i : list) {
            if (!resultList.contains(i)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static void calcOccurrence(List<String> list) {
        List<String> tempList = removeStringDuplicates(list);
        for (String animal : tempList) {
            System.out.printf("%s: %d%n", animal, countOccurrence(list, animal));
        }
    }

    public static List<String> findOccurrence(List<String> list) {
        List<String> tempList = removeStringDuplicates(list);
        List<String> resultList = new ArrayList<>();
        for (String animal : tempList) {
            String str = String.format("{name: \"%s\", occurrence: %d}",
                    animal, countOccurrence(list, animal));
            resultList.add(str);
        }
        return resultList;
    }

    private static List<String> removeStringDuplicates(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (String str : list) {
            if (!resultList.contains(str)) {
                resultList.add(str);
            }
        }
        return resultList;
    }
}
