package ua.hillel.task18;

import java.util.Arrays;

public class ValueCalculator {
    private final float[] numbers;
    private final int size;
    private final int half;

    public ValueCalculator(float[] array) {
        numbers = array;
        size = numbers.length;
        half = size / 2;
    }

    public void doCalc() throws InterruptedException {
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
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arrB.length; i++) {
                arrB[i] = (float) (arrB[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.arraycopy(arrA, 0, numbers, 0, half);
        System.arraycopy(arrB, 0, numbers, half, size - half);
        long totalTime = System.currentTimeMillis() - start;
        System.out.println("Total time: " + totalTime + " ms");
    }
}
