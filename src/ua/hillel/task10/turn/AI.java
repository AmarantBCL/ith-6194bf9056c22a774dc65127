package ua.hillel.task10.turn;

import ua.hillel.task10.checking.CoordinateChecker;
import ua.hillel.task10.coordinates.Coordinate;
import ua.hillel.task10.coordinates.CoordinateValidator;
import ua.hillel.task10.field.Field;
import ua.hillel.task10.input.RandomCoordinateScanner;

public class AI implements PlayerTurn {
    @Override
    public void go(Field field) {
        CoordinateValidator validator = new CoordinateValidator(0, 2);
        RandomCoordinateScanner randomCoordinateScanner = new RandomCoordinateScanner();
        CoordinateChecker coordinateChecker = new CoordinateChecker();
        Coordinate randomCoordinate;
        do {
            randomCoordinate = randomCoordinateScanner.scan();
        } while (validator.notValid(randomCoordinate) ||
                coordinateChecker.notFree(randomCoordinate, field));
        field.setValue(randomCoordinate.getH(), randomCoordinate.getV(), 'O');
    }
}
