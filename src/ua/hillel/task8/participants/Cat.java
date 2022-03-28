package ua.hillel.task8.participants;

public class Cat extends Participant {
    private double runLimit = 200;
    private double jumpLimit = 1.5;

    public Cat(String name) {
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
