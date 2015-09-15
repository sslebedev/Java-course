package lesson1;

public class LSD {

    public static void main(String[] args) {
        SortChecker.Result total = new SortChecker.Result();

        int c = 200;

        for (int i = 0; i < c; i++) {
            SortChecker.Result iteration = SortChecker.MakeIteration(data2 -> {
                LSDSort(data2);
                return null;
            });

            total.Append(iteration);
        }

        double av1 = (double) total.getTimeStandard() / SortChecker.Result.TicksPerSecond() / c;
        System.out.println("Elapsed standard = " + av1);

        double av2 = (double) total.getTimeExternal() / SortChecker.Result.TicksPerSecond() / c;
        System.out.println("Elapsed checked = " + av2);

        System.out.println("Ratio = " + av1 / av2);

        System.out.println("Passed = " + total.isPassed());
    }

    public static void LSDSort(int[] data) {
        int w = 4;
        int BITS_PER_BYTE = 8;
        int r = 1 << 8;
        int mask = 0xFF;

        int n = data.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {
            int[] count = new int[r + 1];
            for (int i = 0; i < n; i++) {
                int c = (data[i] >> BITS_PER_BYTE * d) & mask;
                count[c + 1]++;
            }

            for (int j = 0; j < r; j++) {
                count[j + 1] += count[j];
            }

            if (d == w - 1) {
                int shift1 = count[r] - count[r / 2];
                int shift2 = count[r / 2];
                for (int j = 0; j < r / 2; j++) {
                    count[j] += shift1;
                }
                for (int j = r / 2; j < r; j++) {
                    count[j] -= shift2;
                }
            }

            for (int i = 0; i < n; i++) {
                int c = (data[i] >> BITS_PER_BYTE * d) & mask;
                aux[count[c]++] = data[i];
            }

            System.arraycopy(aux, 0, data, 0, n);
        }
    }
}