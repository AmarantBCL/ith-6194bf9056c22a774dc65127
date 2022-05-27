package ua.hillel.task21;

public class IntegerTestClass {
    @BeforeSuite
    public void first() {
        System.out.println("Integer BEFORE");
    }

    @Test(priority = 1)
    public void second() {
        System.out.println("Integer #1");
    }

    @AfterSuite
    public void third() {
        System.out.println("Integer AFTER");
    }
}
