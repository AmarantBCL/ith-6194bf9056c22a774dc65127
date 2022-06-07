package ua.hillel.task21;

public class Main {
    public static void main(String[] args) {
        TestRunner.start(IntegerTestClass.class); // Before -> Single method -> After
        TestRunner.start(StringTestClass.class); // Before -> 3 methods randomly - After
        TestRunner.start(DoubleTestClass.class); // 3 methods in order -> After
        TestRunner.start(FloatTestClass.class); // This test will throw an exception
    }
}
