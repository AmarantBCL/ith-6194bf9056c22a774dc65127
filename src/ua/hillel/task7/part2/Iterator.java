package ua.hillel.task7.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Iterator {
    private List<Integer> list = new ArrayList<>();

    public Iterator(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
        }
        Collections.sort(list);
    }

    public boolean hasNext() {
        return list.size() > 0;
    }

    public int next() {
        int result = list.get(0);
        list.remove(0);
        return result;
    }
}
