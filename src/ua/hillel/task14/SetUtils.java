package ua.hillel.task14;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class SetUtils {
    public static Set<String> convertToUnique(List<String> strings) {
        return new HashSet<>(strings);
    }

    public static Set<Integer> getSortedUniqueIntegersASC(List<Integer> numbers) {
        return new TreeSet<>(numbers);
    }

    public static Set<Integer> getSortedUniqueIntegersDESC(List<Integer> numbers) {
        Set<Integer> orderedNumbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        orderedNumbers.addAll(numbers);
        return orderedNumbers;
    }

    public static Set<String> buildSentenceDirection(List<String> strings) {
        return new LinkedHashSet<>(strings);
    }
}
