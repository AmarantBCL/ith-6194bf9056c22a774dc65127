package ua.hillel.task10;

import ua.hillel.task10.gameplay.Gameplay;

public class Main {
    public static void main(String[] args) {
        Gameplay gameplay = new Gameplay();
        do {
            gameplay.humanTurn();
            if (gameplay.checkWinDraw()) break;
            System.out.println("AI turn...");
            gameplay.aiTurn();
            if (gameplay.checkWinDraw()) break;
        } while (gameplay.notFinished());
    }
}
