package ua.hillel.task19;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PetrolStation {
    public static final int MAX_REFUELS_AT_TIME = 2;
    private static final int MIN_REFUEL_TIME = 3;
    private static final int MAX_REFUEL_TIME = 10;

    private float amount;
    private Random random = new Random();
    private Semaphore semaphore = new Semaphore(MAX_REFUELS_AT_TIME);
    private ReadWriteLock lock = new ReentrantReadWriteLock();

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

    public void doRefuel(float fuel) {
        try {
            semaphore.acquire();
            if (notEnough(fuel)) {
                System.out.println("CAN'T REFUEL!");
                return;
            }
            int sec = random.nextInt((MAX_REFUEL_TIME - MIN_REFUEL_TIME)) + MIN_REFUEL_TIME;
            System.out.println(sec + " seconds WAITING...");
            Thread.sleep(sec * 1000);
            System.out.println(fuel + " liters");
            changeAmount(fuel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void changeAmount(float fuel) {
        try {
            lock.writeLock().lock();
            amount -= fuel;
        } finally {
            lock.writeLock().unlock();
        }
    }

    private boolean notEnough(float fuel) {
        System.out.println("How much fuel? " + amount + " liters");
        try {
            lock.readLock().lock();
            return amount < fuel;
        } finally {
            lock.readLock().unlock();
        }
    }
}
