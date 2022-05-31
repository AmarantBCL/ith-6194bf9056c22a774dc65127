package ua.hillel.task21;

public class StringTestClass {
    @BeforeSuite
    public void first() {
        System.out.println("String BEFORE");
    }

    @Test
    public void second() {
        System.out.println("String #1");
    }

    @Test
    public void third() {
        System.out.println("String #2");
    }

    @Test
    public void fourth() {
        System.out.println("String #3");
    }

    @AfterSuite
    public void fifth() {
        System.out.println("String AFTER");
    }
}
