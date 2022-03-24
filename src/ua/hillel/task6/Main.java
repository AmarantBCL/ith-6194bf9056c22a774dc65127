package ua.hillel.task6;

public class Main {
    public static void main(String[] args) {
        int[] runDistances = new int[] {100, 150, 500, 1000};
        int[] swimDistances = new int[] {2, 5, 10, 30};
        Cat cat1 = new Cat("Мурзик");
        Cat cat2 = new Cat("Барсик");
        Dog dog1 = new Dog("Рэкс");
        for (int distance : runDistances) {
            cat1.run(distance);
            cat2.run(distance);
            dog1.run(distance);
        }
        for (int distance : swimDistances) {
            dog1.swim(distance);
        }
        System.out.printf("Всего котиков: %d%n", Cat.getCount());
        System.out.printf("Всего собачек: %d%n", Dog.getCount());
    }
}
