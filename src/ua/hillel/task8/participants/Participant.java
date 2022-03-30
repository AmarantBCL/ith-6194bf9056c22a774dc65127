package ua.hillel.task8.participants;

public abstract class Participant {
    private final String name;
    private final double runLimit;
    private final double jumpLimit;

    public Participant(String name, double runLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public String getName() {
        return name;
    }

    public double getRunLimit() {
        return runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    public void run() {
        System.out.printf("Участник[%s] бежит%n", name);
    }

    public void jump() {
        System.out.printf("Участник[%s] прыгает%n", name);
    }
}
