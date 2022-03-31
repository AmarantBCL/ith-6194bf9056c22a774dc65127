package ua.hillel.task8.participants;

public class Cat extends Participant {
    public Cat(String name, double runLimit, double jumpLimit) {
        super(name, runLimit, jumpLimit);
    }

    @Override
    public void run() {
        System.out.printf("Cat[%s] бежит%n", getName());
    }

    @Override
    public void jump() {
        System.out.printf("Cat[%s] прыгает%n", getName());
    }
}
