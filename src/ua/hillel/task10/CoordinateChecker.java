package ua.hillel.task10;

public class CoordinateChecker {
    public boolean valid(Coordinate coordinate, Field field) {
        CoordinateValidator validator = new CoordinateValidator(0, 2);
        return (validator.valid(coordinate) && isFree(coordinate, field));
    }

    public boolean notValid(Coordinate coordinate, Field field) {
        return !valid(coordinate, field);
    }

    private boolean isFree(Coordinate coordinate, Field field) {
        if (coordinate == null) return false;
        char[][] data = field.getData();
        return data[coordinate.getH()][coordinate.getV()] == Field.EMPTY_SYMBOL;
    }
}
