package ua.hillel.task7;

public class Square implements ua.hillel.task7.Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateSquare() {
        return side * side;
    }
}
