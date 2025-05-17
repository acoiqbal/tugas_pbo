public class Array2DExample {
    public static void main(String[] args) {
        double[][] data = {
            {91.35, 4.72, 26, 3.5, 8, 61, 65.36, 12, 5.6, 7.11},
            {27, 9.53, 549, 2.23, 17.31, 4.25, 2.13, 83, 7, 102.4},
            {53.21, 3.42, 0.21, 70.02, 819.4, 6173, 4.25, 19.8, 17.35, 5.768}
        };

        double sum = 0;
        double min = data[0][0];
        double max = data[0][0];
        int count = 0;

        System.out.println("Isi Array 2D:");
        for (double[] row : data) {
            for (double val : row) {
                System.out.print(val + "\t");

                // Hitung total sum, min, max
                sum += val;
                if (val < min) min = val;
                if (val > max) max = val;
                count++;
            }
            System.out.println();
        }

        double average = sum / count;

        // Tampilkan hasil statistik
        System.out.println("\nStatistik Data:");
        System.out.println("MIN     : " + min);
        System.out.println("MAX     : " + max);
        System.out.println("SUM     : " + sum);
        System.out.println("AVERAGE : " + average);
    }
}
