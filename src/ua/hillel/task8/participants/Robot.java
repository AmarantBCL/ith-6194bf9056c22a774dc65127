package ua.hillel.task8.participants;

public class Robot extends Participant {
    private double runLimit = 10000;
    private double jumpLimit = 2.0;

    public Robot(String name) {
        super(name);
    }

    @Override
    public double findRunLimit() {
        return runLimit;
    }

    @Override
    public double findJumpLimit() {
        return jumpLimit;
    }
}
