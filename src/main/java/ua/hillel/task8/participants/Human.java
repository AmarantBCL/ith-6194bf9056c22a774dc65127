package ua.hillel.task8.participants;

public class Human extends Participant {
    public Human(String name, double runLimit, double jumpLimit) {
        super(name, runLimit, jumpLimit);
    }

    @Override
    public void run() {
        System.out.printf("Human[%s] бежит%n", getName());
    }

    @Override
    public void jump() {
        System.out.printf("Human[%s] прыгает%n", getName());
    }
}
