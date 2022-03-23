package ua.hillel.task6;

public class Main {
    public static void main(String[] args) {
        int[] runDistances = new int[] {150, 100, 500, 1000};
        int[] swimDistances = new int[] {2, 5, 10, 30};
        for (Animal animal : getAnimals()) {
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
        Animal[] animals = new Animal[]{new Cat("Антончик"), new Cat("Беня"), new Dog("Толстый")};

        return animals;
    }
}
