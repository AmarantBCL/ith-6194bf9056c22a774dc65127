package ua.hillel.task10.gameplay;

import ua.hillel.task10.checking.DrawChecker;
import ua.hillel.task10.checking.WinChecker;
import ua.hillel.task10.field.Field;
import ua.hillel.task10.field.FieldDrawer;
import ua.hillel.task10.turn.PlayerTurn;

public class Gameplay {
    private final Field field;
    private final FieldDrawer fieldDrawer;
    private boolean inProgress;

    public Gameplay() {
        inProgress = true;
        this.field = new Field();
        this.fieldDrawer = new FieldDrawer();
        fieldDrawer.draw(field);
    }

    public void turn(PlayerTurn playerTurn) {
        playerTurn.go(field);
        fieldDrawer.draw(field);
    }

    public boolean checkWinDraw() {
        WinChecker winChecker = new WinChecker(field);
        DrawChecker drawChecker = new DrawChecker(field);
        if (winChecker.check() || drawChecker.check()) {
            inProgress = false;
            show(winChecker.getWinner());
            return true;
        }
        return false;
    }

    public boolean notFinished() {
        return inProgress;
    }

    public boolean again() {
        return new RematchScanner().ask();
    }

    private void show(String winner) {
        if (winner != null) {
            System.out.println("The winner is '" + winner + "'!");
        } else {
            System.out.println("DRAW!");
        }
    }
}
