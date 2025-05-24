import java.util.LinkedList;
import java.util.Queue;

public class QueueDataStats {
    public static void main(String[] args) {
        // 1. Inisialisasi Queue
        Queue<Double> dataQueue = new LinkedList<>();

        // 2. Data yang akan disimpan
        double[] data = {
            91.35, 4.72, 26, 3.5, 8, 61, 65.36, 12, 5.6, 7.11,
            27, 9.53, 549, 2.23, 17.31, 4.25, 2.13, 83, 7, 102.4,
            53.21, 3.42, 0.21, 70.02, 819.4, 6173, 4.25, 19.8, 17.35, 5.768
        };

        // 3. Menyimpan data ke dalam Queue
        for (double d : data) {
            dataQueue.offer(d); // offer digunakan untuk enqueue
        }

        // 4. Cetak isi Queue
        System.out.println("Isi Queue:");
        for (double d : dataQueue) {
            System.out.print(d + " ");
        }
        System.out.println("\n");

        // 5. Hitung MIN, MAX, SUM, AVERAGE
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;

        for (double d : dataQueue) {
            if (d < min) min = d;
            if (d > max) max = d;
            sum += d;
        }

        double average = sum / dataQueue.size();

        // 6. Tampilkan hasil
        System.out.printf("MIN     : %.3f\n", min);
        System.out.printf("MAX     : %.3f\n", max);
        System.out.printf("SUM     : %.3f\n", sum);
        System.out.printf("AVERAGE : %.3f\n", average);
    }
}
