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
        return new Participant[]{new Human("Human"), new Cat("Cat"),
                new Robot("Robot")};
    }

    private static Obstacle[] getObstacles() {
        return new Obstacle[]{new Track(100),
                new Wall(1.1)};
    }
}
