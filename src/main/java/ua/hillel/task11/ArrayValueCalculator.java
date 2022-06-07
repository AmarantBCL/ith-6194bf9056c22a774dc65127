package ua.hillel.task11;

public class ArrayValueCalculator {
    private static final int MAX_LENGTH = 4;

    public static int doCalc(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        checkLength(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                checkLength(arr[i].length);
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Not number value in cell: [%d, %d]", i, j), e);
                }
            }
        }
        return sum;
    }

    private static void checkLength(int length) throws MyArraySizeException {
        if (length != MAX_LENGTH) {
            throw new MyArraySizeException(String.format("Wrong array size (not %dx%d)", MAX_LENGTH, MAX_LENGTH));
        }
    }
}
