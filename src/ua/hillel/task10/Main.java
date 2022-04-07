package ua.hillel.task10;

import ua.hillel.task10.gameplay.Gameplay;
import ua.hillel.task10.turn.AI;
import ua.hillel.task10.turn.Human;
import ua.hillel.task10.turn.Turner;

public class Main {
    private static final Turner[] PLAYERS = {new Human(), new AI()};

    public static void main(String[] args) {
        Gameplay gameplay = new Gameplay();
        do {
            for (Turner turner : PLAYERS) {
                gameplay.turn(turner);
                if (gameplay.checkWinDraw()) break;
            }
        } while (gameplay.notFinished());
    }
}
