package ua.hillel.task10;

public class CoordinateChecker {
    public boolean isFree(Coordinate coordinate, Field field) {
        char[][] data = field.getData();
        return data[coordinate.getH()][coordinate.getV()] == Field.EMPTY_SYMBOL;
    }
}
