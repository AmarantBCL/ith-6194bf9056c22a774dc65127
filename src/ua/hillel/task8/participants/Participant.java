package ua.hillel.task8.participants;

import ua.hillel.task8.obstacles.Obstacle;

public abstract class Participant {
    private String name;

    public String getName() {
        return name;
    }

    public Participant(String name) {
        this.name = name;
    }

    public abstract double findRunLimit();

    public abstract double findJumpLimit();

    public void run() {
        System.out.println(name + " бежит");
    }

    public void jump() {
        System.out.println(name + " прыгает");
    }
}
