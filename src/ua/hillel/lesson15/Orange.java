package ua.hillel.lesson15;

public class Orange extends Fruit {
    private static final float WEIGHT = 1.5F;

    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + WEIGHT +
                '}';
    }
}
