package ua.hillel.task6;

public class Cat extends Animal {
    private static final int RUN_LIMIT = 200;
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Cat(String name) {
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
        System.out.printf("%s не умеет плавать!%n", getName());
    }
}
