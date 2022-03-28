package ua.hillel.task8.participants;

public abstract class Participant {
    private final String name;

    public String getName() {
        return name;
    }

    public Participant(String name) {
        this.name = name;
    }

    public abstract double findRunLimit();

    public abstract double findJumpLimit();

    public void run() {
        System.out.printf("Участник[%s] бежит%n", name);
    }

    public void jump() {
        System.out.printf("Участник[%s] прыгает%n", name);
    }
}
