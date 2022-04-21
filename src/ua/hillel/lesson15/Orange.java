package ua.hillel.lesson15;

public class Orange extends Fruit {
    private float weight = 1.5F;

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
