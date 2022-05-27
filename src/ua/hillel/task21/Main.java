package ua.hillel.task21;

public class Main {
    public static void main(String[] args) {
        TestRunner.start(IntegerTestClass.class);
        TestRunner.start(StringTestClass.class);
        TestRunner.start(DoubleTestClass.class);
        TestRunner.start(FloatTestClass.class);
    }
}
