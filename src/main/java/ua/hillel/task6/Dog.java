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

    public void run(int distance) {
        if (distance > RUN_LIMIT) {
            System.out.printf("%s не может пробежать %d м!%n", getName(), distance);
        } else {
            System.out.printf("%s пробежал %d м%n", getName(), distance);
        }
    }

    public void swim(int distance) {
        if (distance > SWIM_LIMIT) {
            System.out.printf("%s не может проплыть %d м!%n", this.getName(), distance);
        } else {
            System.out.printf("%s проплыл %d м%n", this.getName(), distance);
        }
    }
}
