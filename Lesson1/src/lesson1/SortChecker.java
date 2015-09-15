package lesson1;

import javafx.util.Callback;

import java.util.Random;

public class SortChecker {
    private static final int SIZE = 1000000;

    private static Random random = new Random();

    private static int[] dataSample = generate();

    public static Result MakeIteration(Callback<int[], Void> sortToCompare) {
        int[] data1 = dataSample.clone();
        int[] data2 = dataSample.clone();

        long start = System.nanoTime();
        java.util.Arrays.sort(data1);
        long stop = System.nanoTime();

        long nanoTime1 = stop - start;

        start = System.nanoTime();
        sortToCompare.call(data2);
        stop = System.nanoTime();
        long nanoTime2 = stop - start;

        boolean isPassed = java.util.Arrays.equals(data1, data2);

        return new Result(nanoTime1, nanoTime2, isPassed);
    }

    public static class Result {
        long time1;
        long time2;
        boolean passed;

        public Result(long time1, long time2, boolean passed) {
            this.time1 = time1;
            this.time2 = time2;
            this.passed = passed;
        }

        public long getTime1() {
            return time1;
        }

        public long getTime2() {
            return time2;
        }

        public boolean isPassed() {
            return passed;
        }

        public long TicksPerSecond() {
            return 10 ^ 9;
        }

        public void Append(Result nextResult) {
            time1 += nextResult.time1;
            time2 += nextResult.time2;
            passed = passed && nextResult.passed;
        }
    }

    private static int[] generate() {
        int[] data = new int[SIZE];

        for (int k = 0; k < data.length; k++) {
            data[k] = random.nextInt(SIZE);
        }

        return data;
    }
}
