package ua.hillel;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] testArr = new int[] {1, 2, 4, 3, 10, 9, 5, 8, 4, 7};
        System.out.println(Arrays.toString(sortArrayByParity(testArr)));
    }

    private static int[] sortArrayByParity(int[] array) {
        int[] newArr = new int[array.length];
        int begin = -1;
        int end = array.length;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] % 2 == 0 ? ++begin : --end;
            newArr[index] = array[i];
        }

        return newArr;
    }
}
