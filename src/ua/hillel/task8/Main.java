package ua.hillel.task8;

import ua.hillel.task8.participants.*;
import ua.hillel.task8.obstacles.*;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = getParticipants();
        Obstacle[] obstacles = getObstacles();
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    break;
                }
            }
        }
    }

    private static Participant[] getParticipants() {
        return new Participant[]{new Human("Human", 1000, 1),
                new Cat("Cat", 300, 1.5),
                new Robot("Robot", 5000, 0.5)};
    }

    private static Obstacle[] getObstacles() {
        return new Obstacle[]{new Track(100),
                new Wall(0.5),
                new Track(200),
                new Wall(0.8),
                new Track(500),
                new Wall(1.1),
                new Track(1000),};
    }
}
