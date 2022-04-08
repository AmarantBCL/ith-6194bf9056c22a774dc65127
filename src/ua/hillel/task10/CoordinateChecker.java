package ua.hillel.task10;

public class CoordinateChecker {
    public boolean isFree(Coordinate coordinate, Field field) {
        char[][] data = field.getData();
        return data[coordinate.getH()][coordinate.getV()] == Field.EMPTY_SYMBOL;
    }

    public boolean notFree(Coordinate coordinate, Field field) {
        return !isFree(coordinate, field);
    }
}
