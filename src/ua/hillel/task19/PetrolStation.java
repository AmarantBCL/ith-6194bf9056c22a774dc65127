package ua.hillel.task19;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PetrolStation {
    public static final int MAX_REFUELS_AT_TIME = 3;
    private static final int MIN_REFUEL_TIME = 3;
    private static final int MAX_REFUEL_TIME = 10;

    private float amount;
    private final Random random = new Random();
    private final Semaphore semaphore = new Semaphore(MAX_REFUELS_AT_TIME);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public float getAmount() {
        try {
            lock.readLock().lock();
            return amount;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void doRefuel(float fuel) throws InterruptedException {
        try {
            semaphore.acquire();
            int sec = random.nextInt((MAX_REFUEL_TIME - MIN_REFUEL_TIME)) + MIN_REFUEL_TIME;
            Thread.sleep(sec * 1000);
            depleteFuel(fuel);
        } finally {
            semaphore.release();
        }
    }

    private void depleteFuel(float fuel) {
        try {
            lock.writeLock().lock();
            amount -= (getAmount() - fuel >= 0) ? fuel : amount;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
