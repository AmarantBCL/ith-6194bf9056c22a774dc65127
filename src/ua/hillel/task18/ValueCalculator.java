package ua.hillel.task18;

import java.util.Arrays;

public class ValueCalculator {
    private float[] numbers;
    private int size;
    private int half;

    public ValueCalculator(float[] array) {
        numbers = array;
        size = numbers.length;
        half = size / 2;
    }

    public void doCalc() {
        long start = System.currentTimeMillis();
        float[] arrA = new float[half];
        float[] arrB = new float[size - half];
        Arrays.fill(numbers, 1);
        System.arraycopy(numbers, 0, arrA, 0, half);
        System.arraycopy(numbers, half, arrB, 0, size - half);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arrA.length; i++) {
                arrA[i] = (float) (arrA[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Thread #1 done!");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arrB.length; i++) {
                arrB[i] = (float) (arrB[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Thread #2 done!");
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arrA, 0, numbers, 0, half);
        System.arraycopy(arrB, 0, numbers, half, size - half);
        long totalTime = System.currentTimeMillis() - start;
        System.out.println("Total time: " + totalTime + " ms");
    }
}
