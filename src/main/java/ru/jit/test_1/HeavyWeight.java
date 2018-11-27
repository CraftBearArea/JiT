package ru.jit.test_1;

public class HeavyWeight {

    public static void doSomeStuff() {
        double uselessSum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                uselessSum += i * j;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {


        doSomeStuff();

        int nThreads = 100;
        Thread[] threads = new Thread[100];
        for (int i = 0; i < nThreads; i++)
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    doSomeStuff();
                }
            });
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++)
            threads[i].start();
        for (int i = 0; i < threads.length; i++)
            threads[i].join();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }


}
