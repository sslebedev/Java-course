package com.company;

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

    public static int FibMatrix(int n) {
        //���������� n-� ����� ���������
        int a = 1, ta,
            b = 1, tb,
            c = 1, rc = 0, tc,
            d = 0, rd = 1;

        while (n > 0) {
            if ((n & 1) != 0)    // ���� ������� ��������
            {
                // �������� ������ R �� ������� A
                tc = rc;
                rc = rc * a + rd * c;
                rd = tc * b + rd * d;
            }

            // �������� ������� A �� ���� ����
            ta = a;
            tb = b;
            tc = c;
            a = a * a + b * c;
            b = ta * b + b * d;
            c = c * ta + d * c;
            d = tc * tb + d * d;

            n >>= 1;  // ��������� ������� �����
        }
        return rc;
    }

    public static void main(String[] args) {
        int times = 50;
        int n = 40;
        System.out.println(TimeChecker.CalcAverageOperationTime(() -> FibDynamic(n), times));
        System.out.println(TimeChecker.CalcAverageOperationTime(() -> FibFunctional(n), times));
        System.out.println(TimeChecker.CalcAverageOperationTime(() -> FibMatrix(n), times));
    }
}
