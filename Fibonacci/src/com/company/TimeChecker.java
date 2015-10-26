package com.company;

/**
 * Created by sslebedev on 26.10.2015.
 */
public class TimeChecker {
    public static long CalcSingleOperationTime(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long stop = System.nanoTime();

        return stop - start;
    }

    public static long CalcAverageOperationTime(Runnable runnable, int times) {
        long sum = 0;

        for (int i = 0; i < times; i++) {
            sum += CalcSingleOperationTime(runnable);
        }

        return sum / times;
    }
}
