package ua.hillel.task7.part1;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = getShapes();
        System.out.println("Сумма площадей всех фигур: " + sumSquare(shapes));
    }

    private static Shape[] getShapes() {
        return new Shape[]{new Circle(10),
                new Triangle(3, 4, 5),
                new Square(2)
        };
    }

    private static double sumSquare(Shape[] shapes) {
        double squareSum = 0;
        for (Shape shape : shapes) {
            squareSum += shape.calculateSquare();
        }
        return squareSum;
    }
}
