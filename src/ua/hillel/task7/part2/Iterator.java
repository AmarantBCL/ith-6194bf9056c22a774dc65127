package ua.hillel.task7.part2;

import java.util.Arrays;

public class Iterator {
    private int[] array;

    public Iterator(int[][] arr) {
        convertToSimpleArray(arr);
    }

    public boolean hasNext() {
        return array.length > 0;
    }

    public int next() {
        int result = array[0];
        remove();

        return result;
    }

    private void convertToSimpleArray (int[][] arr) {
        int size = findArraySize(arr);
        array = new int[size];
        int i = 0;
        for (int[] subArr : arr) {
            for (int value : subArr) {
                array[i] = value;
                i++;
            }
        }
        Arrays.sort(array);
    }

    private int findArraySize(int[][] arr) {
        int size = 0;
        for (int[] subArr : arr) {
            size += subArr.length;
        }

        return size;
    }

    private void remove() {
        int[] newArr = new int[array.length - 1];
        System.arraycopy(array, 1, newArr, 0, array.length - 1);
        array = newArr;
    }
}
