package ru.geekbrains.homeworks.homeworkMultiThreading;

import java.util.Arrays;

public class MyThread {

    static final int size = 10000000;
    static float[] referenceArr;


    public static void main(String[] args) {
        oneThread();
        multiThread(4);
    }

    public static void oneThread() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.printf("One thread  time is %d ms\n", System.currentTimeMillis() - a);
        referenceArr = Arrays.copyOf(arr, arr.length);
    }

    public static void multiThread(int countThread) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        int count = size / countThread;
        Thread[] threads = new Thread[countThread];
        long a = System.currentTimeMillis();
        if (size % countThread == 0) {
            for (int i = 0; i < size; i += count) {
            int tmp = i;
           threads[i / count] = new Thread(() -> {
                    for (int j = 0; j < count; j++) {
                        arr[j + tmp] = (float) (arr[j + tmp] * Math.sin(0.2f + (j + tmp) / 5) * Math.cos(0.2f + (j + tmp) / 5) * Math.cos(0.4f + (j + tmp) / 2));
                    }
                    System.out.printf("Count of completed cells in thread %s: %d\n", Thread.currentThread().getName(), count);
                });
                threads[i / count].start();
            }
        }
        for (int i = 0; i < countThread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%d Thread time is %d ms\n", countThread, System.currentTimeMillis() - a);
        if (!Arrays.equals(referenceArr, arr)) {
            System.out.println("Error of copy");
        }
        else {
            System.out.println("Arrays is equals! It's ok!");
        }

    }
}

