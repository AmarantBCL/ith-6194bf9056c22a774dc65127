package ua.hillel.task8.participants;

public class Robot extends Participant {
    private final double runLimit = 10000;
    private final double jumpLimit = 2.0;

    public Robot(String name) {
        super(name);
    }

    public double findRunLimit() {
        return runLimit;
    }

    public double findJumpLimit() {
        return jumpLimit;
    }
}
