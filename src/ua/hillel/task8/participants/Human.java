package ua.hillel.task8.participants;

public class Human extends Participant {
    private double runLimit = 3000;
    private double jumpLimit = 1.0;

    public Human(String name) {
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
