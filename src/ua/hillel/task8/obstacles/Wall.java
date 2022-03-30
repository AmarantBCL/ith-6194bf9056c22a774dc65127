package ua.hillel.task8.obstacles;

import ua.hillel.task8.participants.Participant;

public class Wall implements Obstacle {
    private final double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        double jumpLimit = participant.getJumpLimit();
        if (jumpLimit >= height) {
            participant.jump();
            System.out.printf("Участник[%s] прошёл препятствие[Wall] на дистанции[%s]%n",
                    participant.getName(), height);
            return true;
        }
        System.out.printf("Участник[%s] не прошёл препятствие[Wall] на дистанции[%s]. " +
                "Может пройти[%s]%n", participant.getName(), height, jumpLimit);
        return false;
    }
}
