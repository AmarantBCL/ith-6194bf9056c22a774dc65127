package ua.hillel.lesson15;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task #1 tests
        String[] strArr = {"hi", "hey", "yo", "hello"};
        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println(toList(strArr));
        System.out.println(toList(intArr));

        // Task #2 tests
        Apple apple = new Apple();
        Orange orange = new Orange();
        Fruit fruit = new Apple();

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();

        appleBox.putOne(apple);
//        appleBox.addOne(orange);
//        appleBox.addOne(fruit);

//        orangeBox.add(apple);
        orangeBox.putOne(orange);
//        orangeBox.add(fruit);

        fruitBox.putOne(apple);
        fruitBox.putOne(orange);
        fruitBox.putOne(fruit);

        List<Apple> apples = Arrays.asList(new Apple(), new Apple());
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange(), new Orange());

        appleBox.putMany(apples);
//        appleBox.addSeveral(oranges);

//        orangeBox.addSeveral(apples);
        orangeBox.putMany(oranges);

        appleBox.print();
        orangeBox.print();

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
    }

    public static <T> List<T> toList(T[] array) {
        return Arrays.asList(array);
    }
}
