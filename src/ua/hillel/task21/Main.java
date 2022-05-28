package ua.hillel.task21;

public class Main {
    public static void main(String[] args) {
        TestRunner.start(IntegerTestClass.class); // OK
        TestRunner.start(StringTestClass.class); // OK
        TestRunner.start(DoubleTestClass.class); // OK
        TestRunner.start(FloatTestClass.class); // This test will throw an exception
    }
}
