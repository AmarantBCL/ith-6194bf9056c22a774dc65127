package ua.hillel.task11;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"12", "4", "16", "8"},
                {"TEST", "12", "2", "18"},
                {"1", "13", "11", "9"},
                {"6", "7", "12", "19"}
        };
        try {
            System.out.println(ArrayValueCalculator.doCalc(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
