package ua.hillel.task8.obstacles;

import ua.hillel.task8.participants.Participant;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public boolean overcome(Participant participant) {
        if (participant.findJumpLimit() > height) {
            participant.jump();
            System.out.printf("Участник[%s] прошёл препятствие[%s] на дистанции[%s]%n",
                    participant.getName(), "Wall", height);
            return true;
        }
        System.out.printf("Участник[%s] не прошел препятствие[%s] на дистанции[%s]. " +
                "Пройдено[%s]%n", participant.getName(), "Wall", height, "?");
        return false;
    }
}
