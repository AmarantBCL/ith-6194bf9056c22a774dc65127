package ua.hillel.task10.turn;

import ua.hillel.task10.checking.CoordinateChecker;
import ua.hillel.task10.coordinates.Coordinate;
import ua.hillel.task10.coordinates.CoordinateValidator;
import ua.hillel.task10.field.Field;
import ua.hillel.task10.input.StdoutCoordinateScanner;

public class Human implements PlayerTurn {
    @Override
    public void go(Field field) {
        CoordinateValidator validator = new CoordinateValidator(0, 2);
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        Coordinate coordinate;
        do {
            coordinate = new StdoutCoordinateScanner().scan();
        } while (validator.notValid(coordinate) ||
                coordinateChecker.notFree(coordinate, field));
        field.setValue(coordinate.getH(), coordinate.getV(), 'X');
    }
}
