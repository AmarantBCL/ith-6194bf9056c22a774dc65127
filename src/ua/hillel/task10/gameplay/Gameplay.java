package ua.hillel.task10.gameplay;

import ua.hillel.task10.checking.DrawChecker;
import ua.hillel.task10.checking.WinChecker;
import ua.hillel.task10.field.Field;
import ua.hillel.task10.field.FieldDrawer;
import ua.hillel.task10.turn.Turner;

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

    public void turn(Turner turner) {
        turner.go(field);
        fieldDrawer.draw(field);
    }

    public boolean checkWinDraw() {
        WinChecker winChecker = new WinChecker(field);
        DrawChecker drawChecker = new DrawChecker(field);
        String winner = winChecker.check();
        if (winner != null || drawChecker.check()) {
            inProgress = false;
            show(winner);
            return true;
        }
        return false;
    }

    public boolean notFinished() {
        return inProgress;
    }

    private void show(String winner) {
        if (winner != null) {
            System.out.println("The winner is '" + winner + "'!");
        } else {
            System.err.println("DRAW!");
        }
    }
}
