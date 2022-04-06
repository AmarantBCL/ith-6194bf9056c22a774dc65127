package ua.hillel.task8.obstacles;

import ua.hillel.task8.participants.Participant;

public class Track implements Obstacle {
    private final double length;

    public Track(double length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        double runLimit = participant.getRunLimit();
        if (runLimit >= length) {
            participant.run();
            System.out.printf("Участник[%s] прошёл препятствие[Track] на дистанции[%s]%n",
                    participant.getName(), length);
            return true;
        }
        System.out.printf("Участник[%s] не прошёл препятствие[Track] на дистанции[%s]. " +
                "Может пройти[%s]%n", participant.getName(), length, runLimit);
        return false;
    }
}
