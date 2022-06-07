package ua.hillel.task10;

import java.util.Scanner;

public class StdoutCoordinateScanner implements CoordinateScanner {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Coordinate scan() {
        String[] coordinates;
        do {
            System.out.println("Please enter coordinates: `hor,vert`. For instance `1,2` ...");
            coordinates = scanner.nextLine().split(",");
        } while (coordinates.length != 2);
        return new Coordinate(Integer.parseInt(coordinates[0]) - 1, Integer.parseInt(coordinates[1]) - 1);
    }
}
