package ua.hillel.task8.participants;

public class Robot extends Participant {
    public Robot(String name, double runLimit, double jumpLimit) {
        super(name, runLimit, jumpLimit);
    }

    @Override
    public void run() {
        System.out.printf("Robot[%s] бежит%n", getName());
    }

    @Override
    public void jump() {
        System.out.printf("Robot[%s] прыгает%n", getName());
    }
}
