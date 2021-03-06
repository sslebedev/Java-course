package lesson1;

public final class LSD {

    public static void main(String[] args) {
        SortChecker.Result total = new SortChecker.Result();

        final int c = 400;

        for (int i = 0; i < c; i++) {
            SortChecker.Result iteration = SortChecker.MakeIteration(data -> {
                LSDSort(data);
                return null;
            });

            total.Append(iteration);
        }

        double av1 = (double) total.getTimeStandard() / SortChecker.Result.TicksPerSecond / c;
        System.out.println("Elapsed standard = " + av1);

        double av2 = (double) total.getTimeExternal() / SortChecker.Result.TicksPerSecond / c;
        System.out.println("Elapsed checked = " + av2);

        System.out.println("Ratio = " + av1 / av2);

        System.out.println("Passed = " + total.isPassed());
    }

    private static int[] aux = new int[10];

    // there is some constants
    private static final int W = 4;
    private static final int BITS_PER_BYTE = 8;
    private static final int R = 1 << 8;
    private static final int MASK = 0xFF;
    private static final int[] counts = new int[R + 1];
    private static final int[] countsZero = new int[R + 1];

    public static void LSDSort(int[] data) {
        int n = data.length;
        if (n != aux.length) {
            aux = new int[n];
        }

        for (int d = 0; d < 3; d++) { // optimize for max of 1kk
            System.arraycopy(countsZero, 0, counts, 0, R + 1);

            for (int i = 0; i < n; i++) {
                int c = (data[i] >> BITS_PER_BYTE * d) & MASK;
                counts[c + 1]++;
            }

            for (int j = 0; j < R; j++) {
                counts[j + 1] += counts[j];
            }

            // Numbers are non-negative

            for (int i = 0; i < n; i++) {
                int c = (data[i] >> BITS_PER_BYTE * d) & MASK;
                aux[counts[c]++] = data[i];
            }

            System.arraycopy(aux, 0, data, 0, n);
        }
    }
}