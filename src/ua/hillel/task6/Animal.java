package ua.hillel.task6;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract int findRunLimit();

    public abstract int findSwimLimit();

    public void run(int distance) {
        if (distance > findRunLimit()) {
            System.out.printf("%s не может пробежать %d м!%n", name, distance);
        } else {
            System.out.printf("%s пробежал %d м%n", name, distance);
        }
    }

    public void swim(int distance) {
        if (distance > findSwimLimit()) {
            System.out.printf("%s не может проплыть %d м!%n", name, distance);
        } else {
            System.out.printf("%s проплыл %d м%n", name, distance);
        }
    }
}
