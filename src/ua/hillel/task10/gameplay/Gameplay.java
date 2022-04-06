package ua.hillel.task10.gameplay;

import ua.hillel.task10.checking.CoordinateChecker;
import ua.hillel.task10.checking.DrawChecker;
import ua.hillel.task10.checking.WinChecker;
import ua.hillel.task10.coordinates.Coordinate;
import ua.hillel.task10.coordinates.CoordinateValidator;
import ua.hillel.task10.field.Field;
import ua.hillel.task10.field.FieldDrawer;
import ua.hillel.task10.input.RandomCoordinateScanner;
import ua.hillel.task10.input.StdoutCoordinateScanner;

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

    public void humanTurn() {
        CoordinateValidator validator = new CoordinateValidator(0, 2);
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        Coordinate coordinate;
        do {
            coordinate = new StdoutCoordinateScanner().scan();
        } while (validator.notValid(coordinate) ||
                coordinateChecker.notFree(coordinate, field));
        field.setValue(coordinate.getH(), coordinate.getV(), 'X');
        fieldDrawer.draw(field);
    }

    public void aiTurn() {
        CoordinateValidator validator = new CoordinateValidator(0, 2);
        RandomCoordinateScanner randomCoordinateScanner = new RandomCoordinateScanner();
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        Coordinate randomCoordinate;
        do {
            randomCoordinate = randomCoordinateScanner.scan();
        } while (validator.notValid(randomCoordinate) ||
                coordinateChecker.notFree(randomCoordinate, field));
        field.setValue(randomCoordinate.getH(), randomCoordinate.getV(), 'O');
        fieldDrawer.draw(field);
    }

    public boolean checkWinDraw() {
        WinChecker winChecker = new WinChecker(field);
        DrawChecker drawChecker = new DrawChecker(field);
        String winner = winChecker.check();
        if (winner != null || drawChecker.check()) {
            inProgress = false;
            new Announcer().show(winner);
            return true;
        }
        return false;
    }

    public boolean notFinished() {
        return inProgress;
    }
}
