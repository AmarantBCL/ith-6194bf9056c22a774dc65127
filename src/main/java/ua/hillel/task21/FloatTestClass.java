package ua.hillel.task21;

public class FloatTestClass {
    @BeforeSuite
    public void first() {
        System.out.println("Float BEFORE #1");
    }

    @BeforeSuite
    public void second() {
        System.out.println("Float BEFORE #2");
    }

    @Test(priority = 1)
    public void third() {
        System.out.println("Float #1");
    }

    @Test(priority = 2)
    public void fourth() {
        System.out.println("Float #2");
    }

    @AfterSuite
    public void fifth() {
        System.out.println("Float AFTER");
    }
}
