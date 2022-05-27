package ua.hillel.task21;

public class DoubleTestClass {
    @Test(priority = 1)
    public void first() {
        System.out.println("Double #1");
    }

    @Test(priority = 2)
    public void second() {
        System.out.println("Double #2");
    }

    @Test(priority = 3)
    public void third() {
        System.out.println("Double #3");
    }

    @AfterSuite
    public void fourth() {
        System.out.println("Double AFTER");
    }
}
