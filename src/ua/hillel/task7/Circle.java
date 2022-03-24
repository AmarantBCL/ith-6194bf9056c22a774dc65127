package ua.hillel.task7;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateSquare() {
        return Math.PI * Math.pow(radius, 2);
    }
}
