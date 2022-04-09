package ua.hillel.task10;

public class CoordinateChecker {
    public boolean check(Coordinate coordinate, Field field) {
        CoordinateValidator validator = new CoordinateValidator(0, 2);
        return (validator.valid(coordinate) && isFree(coordinate, field));
    }

    private boolean isFree(Coordinate coordinate, Field field) {
        char[][] data = field.getData();
        return data[coordinate.getH()][coordinate.getV()] == Field.EMPTY_SYMBOL;
    }
}
