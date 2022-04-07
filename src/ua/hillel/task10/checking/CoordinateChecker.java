package ua.hillel.task10.checking;

import ua.hillel.task10.coordinates.Coordinate;
import ua.hillel.task10.field.Field;

public class CoordinateChecker {
    public boolean notFree(Coordinate coordinate, Field field) {
        char[][] data = field.getData();
        return data[coordinate.getH()][coordinate.getV()] != Field.EMPTY_SYMBOL;
    }
}
