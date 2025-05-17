public class BubbleSortTop5 {
    public static void main(String[] args) {
        // Data array
        double[] data = {
            91.35, 4.72, 26, 3.5, 8, 61, 65.36, 12, 5.6, 7.11,
            27, 9.53, 549, 2.23, 17.31, 4.25, 2.13, 83, 7, 102.4,
            53.21, 3.42, 0.21, 70.02, 819.4, 6173, 4.25, 19.8, 17.35, 5.768
        };

        // Bubble Sort (Descending)
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    double temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        // Tampilkan 5 nilai terbesar
        System.out.println("5 Nilai Terbesar:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i+1) + ". " + data[i]);
        }
    }
}
