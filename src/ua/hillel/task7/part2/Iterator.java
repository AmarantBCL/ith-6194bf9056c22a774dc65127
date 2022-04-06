package ua.hillel.task7.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Iterator {
    private List<Integer> list = new ArrayList<>();

    public Iterator(int[][] arr) {
        for (int[] ints : arr) {
            for (int i : ints) {
                list.add(i);
            }
        }
    }

    public boolean hasNext() {
        return list.size() > 0;
    }

    public int next() {
        int result = Collections.min(list);
        list.remove(Integer.valueOf(result));
        return result;
    }
}
