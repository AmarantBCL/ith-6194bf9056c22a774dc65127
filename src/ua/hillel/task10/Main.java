package ua.hillel.task10;

import ua.hillel.task10.gameplay.Gameplay;
import ua.hillel.task10.turn.AI;
import ua.hillel.task10.turn.Human;
import ua.hillel.task10.turn.PlayerTurn;

public class Main {
    private static final PlayerTurn[] PLAYERS = {new Human(), new AI()};

    public static void main(String[] args) {
        boolean playing = true;
        while (playing) {
            Gameplay gameplay = new Gameplay();
            do {
                for (PlayerTurn playerTurn : PLAYERS) {
                    gameplay.turn(playerTurn);
                    if (gameplay.checkWinDraw()) {
                        playing = gameplay.again();
                        break;
                    }
                }
            } while (gameplay.notFinished());
        }
    }
}
