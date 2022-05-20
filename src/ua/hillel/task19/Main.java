package ua.hillel.task19;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int MIN_LITERS = 5;
    private static final int MAX_LITERS = 50;

    public static void main(String[] args) throws Exception {
        PetrolStation station = new PetrolStation(50);

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                station.doRefuel(random.nextInt(MAX_LITERS - MIN_LITERS) + MIN_LITERS);
                System.out.println("PETROL STATION amount: " + station.getAmount());
            });
            //thread.start();
        }
    }
}
