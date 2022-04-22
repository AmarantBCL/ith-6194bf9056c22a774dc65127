package ua.hillel.lesson15;

public class Apple extends Fruit {
    private static final float WEIGHT = 1.0F;

    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + WEIGHT +
                '}';
    }
}
