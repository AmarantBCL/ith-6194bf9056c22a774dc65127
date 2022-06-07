package ua.hillel.task6;

public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
