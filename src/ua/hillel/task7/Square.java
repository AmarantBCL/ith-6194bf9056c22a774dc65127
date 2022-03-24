package ua.hillel.task7;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateSquare() {
        return side * side;
    }
}
