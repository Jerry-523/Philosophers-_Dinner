package Dining;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Philosopher implements Runnable {
    private final int id;
    private final Semaphore leftFork;
    private final Semaphore rightFork;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() throws InterruptedException {
        System.out.println("Dining.Philosopher " + id + " is eating.");
        Thread.sleep(1000); // Simula o tempo que o filósofo leva para comer
    }

    private void think() throws InterruptedException {
        System.out.println("Dining.Philosopher " + id + " is thinking.");
        Thread.sleep(1000); // Simula o tempo que o filósofo leva para pensar
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                leftFork.acquire();
                System.out.println("Dining.Philosopher " + id + " picked up left fork.");

                rightFork.acquire();
                System.out.println("Dining.Philosopher " + id + " picked up right fork.");

                eat();

                leftFork.release();
                System.out.println("Dining.Philosopher " + id + " released left fork.");

                rightFork.release();
                System.out.println("Dining.Philosopher " + id + " released right fork.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numPhilosophers);
        Semaphore[] forks = new Semaphore[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1); // Inicia cada garfo com disponibilidade 1
        }

        for (int i = 0; i < numPhilosophers; i++) {
            int leftForkIndex = i;
            int rightForkIndex = (i + 1) % numPhilosophers;
            executorService.execute(new Philosopher(i, forks[leftForkIndex], forks[rightForkIndex]));
        }

        executorService.shutdown();
    }
}
