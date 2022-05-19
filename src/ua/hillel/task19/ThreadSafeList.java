package ua.hillel.task19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {
    private List<T> list = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(T element) {
        try {
            lock.writeLock().lock();
            list.add(element);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void remove(int index) {
        try {
            lock.writeLock().lock();
            list.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        try {
            lock.readLock().lock();
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }

    }
}
