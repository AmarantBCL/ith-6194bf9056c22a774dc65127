package ua.hillel.task15;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task #1 tests
        String[] strArr = {"hello", "hi", "hey", "yo", "what's up"};
        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println(toList(strArr));
        System.out.println(toList(intArr));

        // Task #2 tests
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        System.out.println("***** putOne *****");
        appleBox.putOne(apple);
        orangeBox.putOne(orange);
        appleBox.print();
        orangeBox.print();

        System.out.println("***** putMany *****");
        List<Apple> apples = Arrays.asList(new Apple(), new Apple());
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange(), new Orange());
        appleBox.putMany(apples);
        orangeBox.putMany(oranges);
        appleBox.print();
        orangeBox.print();

        System.out.println("***** getWeight *****");
        System.out.println("Apple box weight: " + appleBox.getWeight());
        System.out.println("Orange box weight: " + orangeBox.getWeight());

        System.out.println("***** compare *****");
        appleBox.print();
        orangeBox.print();
        System.out.println("The boxes weight is equal: " + appleBox.compare(orangeBox));
        List<Apple> moreApples = Arrays.asList(new Apple(), new Apple(), new Apple());
        appleBox.putMany(moreApples);
        appleBox.print();
        orangeBox.print();
        System.out.println("The boxes weight is equal: " + appleBox.compare(orangeBox));

        System.out.println("***** merge *****");
        Box<Orange> newOrangeBox = new Box<>();
        newOrangeBox.putOne(new Orange());
        newOrangeBox.print();
        newOrangeBox.merge(orangeBox);
        newOrangeBox.print();
        orangeBox.print();
    }

    public static <T> List<T> toList(T[] array) {
        return Arrays.asList(array);
    }
}
