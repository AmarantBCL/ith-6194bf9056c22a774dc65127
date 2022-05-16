package ua.hillel.task18;

public class Main {
    public static void main(String[] args) {
        ValueCalculator calculator = new ValueCalculator(new float[10000000]);
        try {
            calculator.doCalc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
