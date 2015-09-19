package lesson1;

import javafx.util.Callback;

import java.util.Random;

public final class SortChecker {
    private static final int SIZE = 1000000;

    private static Random random = new Random();

    public static Result MakeIteration(Callback<int[], Void> sortToCompare) {
        int[] data1 = generate();
        int[] data2 = data1.clone();

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

    private static int[] generate() {
        int[] data = new int[SIZE];

        for (int k = 0; k < data.length; k++) {
            data[k] = random.nextInt(SIZE);
        }

        return data;
    }

    public static class Result {
        private long timeStandard;
        private long timeExternal;
        private boolean passed;

        public Result() {
            timeStandard = timeExternal = 0;
            passed = true;
        }

        public Result(long timeStandard, long timeExternal, boolean passed) {
            this.timeStandard = timeStandard;
            this.timeExternal = timeExternal;
            this.passed = passed;
        }

        public static final long TicksPerSecond = 1000000000;

        public long getTimeStandard() {
            return timeStandard;
        }

        public long getTimeExternal() {
            return timeExternal;
        }

        public boolean isPassed() {
            return passed;
        }

        public void Append(Result nextResult) {
            timeStandard += nextResult.timeStandard;
            timeExternal += nextResult.timeExternal;
            passed = passed && nextResult.passed;
        }
    }
}
