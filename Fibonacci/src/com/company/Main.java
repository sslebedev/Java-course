package com.company;

import javafx.util.Callback;

public class Main {

    public static int Fib(int n) {
        int[] prev = new int[]{0, 1};

        if (n < 2) {
            return prev[n];
        }

        for (int i = 2; i <= n; i++) {
            int next = prev[0] + prev[1];
            prev[0] = prev[1];
            prev[1] = next;
        }
        return prev[1];
    }

    public static long CalcOperationTime(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long stop = System.nanoTime();

        return stop - start;
    }

    public static void main(String[] args) {
        final int count = 10;
        for (int i = 0; i < count; i++) {
            final int p = i;
            long nt = CalcOperationTime(() -> Fib(p));
            System.out.println(nt);
        }
    }
}
