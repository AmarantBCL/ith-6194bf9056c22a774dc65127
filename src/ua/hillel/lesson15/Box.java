package ua.hillel.lesson15;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public void putOne(T fruit) {
        fruits.add(fruit);
    }

    public void putMany(List<T> fruitsPile) {
        this.fruits.addAll(fruitsPile);
    }

    public float getWeight() {
        float weight = 0.0F;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void print() {
        System.out.println(fruits);
    }
}
