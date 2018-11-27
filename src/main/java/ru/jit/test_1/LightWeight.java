package ru.jit.test_1;

public class LightWeight {

    public static double doSomeStuff() {
        double uselessSum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                uselessSum += i + j;
            }
        }
        return uselessSum;
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
