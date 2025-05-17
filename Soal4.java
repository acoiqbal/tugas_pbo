import java.util.ArrayList;

public class ArrayListStatistik {
    public static void main(String[] args) {
        // Membuat objek ArrayList bertipe Double
        ArrayList<Double> data = new ArrayList<>();

        // Menambahkan data ke ArrayList
        double[] nilai = {
            91.35, 4.72, 26, 3.5, 8, 61, 65.36, 12, 5.6, 7.11,
            27, 9.53, 549, 2.23, 17.31, 4.25, 2.13, 83, 7, 102.4,
            53.21, 3.42, 0.21, 70.02, 819.4, 6173, 4.25, 19.8, 17.35, 5.768
        };

        for (double val : nilai) {
            data.add(val);
        }

        // Menampilkan isi ArrayList
        System.out.println("Isi ArrayList:");
        for (double val : data) {
            System.out.print(val + "\t");
        }

        // Hitung statistik
        double sum = 0, min = data.get(0), max = data.get(0);
        for (double val : data) {
            sum += val;
            if (val < min) min = val;
            if (val > max) max = val;
        }

        double average = sum / data.size();

        // Tampilkan hasil
        System.out.println("\n\nStatistik Data:");
        System.out.println("MIN     : " + min);
        System.out.println("MAX     : " + max);
        System.out.println("SUM     : " + sum);
        System.out.println("AVERAGE : " + average);
    }
}
