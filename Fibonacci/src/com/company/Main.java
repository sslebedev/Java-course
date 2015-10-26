package com.company;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Main {

    public static int FibDynamic(int n) {
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

    public static int FibFunctional(int n) {
        if (n < 2) {
            return n;
        }

        return FibFunctional(n - 1) + FibFunctional((n - 2));
    }

    public static void main(String[] args) {
        System.out.println(TimeChecker.CalcAverageOperationTime(() -> FibDynamic(23), 50));
        System.out.println(TimeChecker.CalcAverageOperationTime(() -> FibFunctional(23), 50));
    }
}
