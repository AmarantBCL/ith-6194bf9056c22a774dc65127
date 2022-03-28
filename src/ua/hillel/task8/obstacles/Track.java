package ua.hillel.task8.obstacles;

import ua.hillel.task8.participants.Participant;

public class Track implements Obstacle {
    private double length;

    public Track(double length) {
        this.length = length;
    }

    public boolean overcome(Participant participant) {
        if (participant.findRunLimit() > length) {
            participant.run();
            System.out.printf("Участник[%s] прошёл препятствие[%s] на дистанции[%s]%n",
                    participant.getName(), "Track", length);
            return true;
        }
        System.out.printf("Участник[%s] не прошел препятствие[%s] на дистанции[%s]. " +
                "Пройдено[%s]%n", participant.getName(), "Track", length, "?");
        return false;
    }
}
