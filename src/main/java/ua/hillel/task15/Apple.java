package ua.hillel.task15;

public class Apple extends Fruit {
    private static final float WEIGHT = 1.0F;

    @Override
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
