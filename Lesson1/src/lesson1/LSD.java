package lesson1;

import java.util.Random;

public class LSD {

    private static final int SIZE = 1000000;

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] data = generate();

        int [] data2 = data.clone();

        long start = System.nanoTime();

        java.util.Arrays.sort(data);

        long stop = System.nanoTime();

        System.out.println("Elapsed = " + (stop - start));

        start = System.nanoTime();
        LSDSort(data2);
        stop = System.nanoTime();

        System.out.println("Elapsed = " + (stop - start));

        System.out.println("Passed = " + java.util.Arrays.equals(data, data2));
    }

    private static void LSDSort(int[] data) {
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

            for (int i = 0; i < n; i++){
                data[i] = aux[i];
            }
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