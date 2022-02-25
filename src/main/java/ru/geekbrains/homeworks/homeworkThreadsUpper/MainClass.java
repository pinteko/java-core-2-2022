package ru.geekbrains.homeworks.homeworkThreadsUpper;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
   public static CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
    public static CountDownLatch start = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch finish = new CountDownLatch(CARS_COUNT);
    public static Lock lock = new ReentrantLock();
    public static Semaphore semaphore = new Semaphore(CARS_COUNT / 2, true);
    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();}

        try {
            start.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            finish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    }


