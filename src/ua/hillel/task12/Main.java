package ua.hillel.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("cat", "dog", "rabbit", "dog", "horse", "dog", "dog",
                "rabbit", "cat", "pig");
        System.out.println(ListUtils.countOccurrence(wordList, "pig"));

        System.out.println(ListUtils.toList(new int[]{1,2,3}));

        List<Integer> intList = Arrays.asList(1, 8, 5, 7, 9, 1, 2, 4, 5, 2, 2, 6, 3, 0, 0);
        System.out.println(ListUtils.findUnique(intList));
    }
}
