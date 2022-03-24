package ua.hillel.task7;

public class Main {
    public static void main(String[] args) {
        ua.hillel.task7.Shape[] shapes = getShapes();
        System.out.println("Сумма площадей всех фигур: " + sumSquare(shapes));
    }

    private static ua.hillel.task7.Shape[] getShapes() {
        return new ua.hillel.task7.Shape[]{new ua.hillel.task7.Circle(10), new ua.hillel.task7.Triangle(3, 4, 5), new ua.hillel.task7.Square(2)};
    }

    private static double sumSquare(ua.hillel.task7.Shape[] shapes) {
        double squareSum = 0;
        for (ua.hillel.task7.Shape shape : shapes) {
            squareSum += shape.calculateSquare();
        }

        return squareSum;
    }
}
