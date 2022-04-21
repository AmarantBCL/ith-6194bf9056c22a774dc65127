package ua.hillel.lesson15;

public class Apple extends Fruit {
    private float weight = 1.0F;

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
