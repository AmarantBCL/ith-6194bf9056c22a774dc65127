package ua.hillel.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        for (Integer i : list) {
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            } else {
                uniqueList.remove(i);
            }
        }
        return uniqueList;
    }
}
