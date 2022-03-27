package ua.hillel.task8.participants;

import ua.hillel.task8.obstacles.*;

public abstract class Participant {
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s has run the track...%n", name);
    }

    public void jump() {
        System.out.printf("%s has jumped over the wall...%n", name);
    }

    public void overcome(Obstacle obstacle) {
        // TODO
    }
}
