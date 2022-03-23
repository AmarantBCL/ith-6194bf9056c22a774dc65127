package ua.hillel.task6;

public class Dog extends Animal {
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Dog(String name) {
        super(name);
        count++;
    }

    public int findRunLimit() {
        return RUN_LIMIT;
    }

    public int findSwimLimit() {
        return SWIM_LIMIT;
    }
}
