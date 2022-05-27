package ua.hillel.task21;

public class StringTestClass {
    @BeforeSuite
    public void first() {
        System.out.println("String BEFORE");
    }

    @Test(priority = 1)
    public void second() {
        System.out.println("String #1");
    }

    @Test(priority = 2)
    public void third() {
        System.out.println("String #2");
    }

    @Test(priority = 3)
    public void fourth() {
        System.out.println("String #3");
    }

    @AfterSuite
    public void fifth() {
        System.out.println("String AFTER");
    }
}
