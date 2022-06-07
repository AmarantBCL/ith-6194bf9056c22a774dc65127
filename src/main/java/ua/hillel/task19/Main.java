package ua.hillel.task19;

import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();
    private static final int MIN_LITERS = 5;
    private static final int MAX_LITERS = 50;

    public static void main(String[] args) {
        PetrolStation station = new PetrolStation(200);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    station.doRefuel(RANDOM.nextInt(MAX_LITERS - MIN_LITERS) + MIN_LITERS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
