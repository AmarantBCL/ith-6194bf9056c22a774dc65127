package ua.hillel.task8.participants;

public class Cat extends Participant {
    private final double runLimit = 200;
    private final double jumpLimit = 1.5;

    public Cat(String name) {
        super(name);
    }

    public double findRunLimit() {
        return runLimit;
    }

    public double findJumpLimit() {
        return jumpLimit;
    }
}
