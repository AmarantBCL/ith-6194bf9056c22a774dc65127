package ua.hillel.task22;

public class ArrayUtils {
    public static int[] lastFourArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                int size = arr.length - i - 1;
                int[] newArr = new int[size];
                System.arraycopy(arr, i + 1, newArr, 0, size);
                return newArr;
            }
        }
        throw new RuntimeException("The array must have at least one element with value = 4");
    }

    public static boolean isOneAndFourArray(int[] arr) {
        boolean isOne = false;
        boolean isFour = false;
        for (int i : arr) {
            if (i != 1 && i != 4) return false;
            if (i == 1) {
                isOne = true;
            } else {
                isFour = true;
            }
        }
        return isOne && isFour;
    }
}
