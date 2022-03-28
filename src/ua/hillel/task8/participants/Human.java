package ua.hillel.task8.participants;

public class Human extends Participant {
    private final double runLimit = 3000;
    private final double jumpLimit = 1.0;

    public Human(String name) {
        super(name);
    }

    public double findRunLimit() {
        return runLimit;
    }

    public double findJumpLimit() {
        return jumpLimit;
    }
}
