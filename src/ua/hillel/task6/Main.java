package ua.hillel.task6;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = getAnimals();
        int[] runDistances = new int[]{100, 150, 500, 1000};
        int[] swimDistances = new int[]{2, 5, 10, 30};
        for (Animal animal : animals) {
            for (int distance : runDistances) {
                animal.run(distance);
            }
            for (int distance : swimDistances) {
                animal.swim(distance);
            }
        }
        System.out.printf("Всего котиков: %d%n", Cat.getCount());
        System.out.printf("Всего собачек: %d%n", Dog.getCount());
    }

    private static Animal[] getAnimals() {
        return new Animal[]{new Cat("Мурзик"), new Cat("Барсик"), new Dog("Рэкс")};
    }
}
