package ua.hillel.task10;

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
