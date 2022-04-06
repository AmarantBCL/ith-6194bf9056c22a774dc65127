package ua.hillel.task10.input;

import ua.hillel.task10.coordinates.Coordinate;
import java.util.Random;

public class RandomCoordinateScanner implements CoordinateScanner {
    private final Random random = new Random();

    @Override
    public Coordinate scan() {
        return new Coordinate(random.nextInt(3), random.nextInt(3));
    }
}
