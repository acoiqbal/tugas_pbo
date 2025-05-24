    import java.util.Scanner;
public class No10 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int hari = 7;
            int kota = 5;
            double[][] suhu = new double[kota][hari];

            System.out.println("Masukkan data suhu udara harian selama 7 hari untuk 5 kota:");

            // Input data suhu
            for (int i = 0; i < kota; i++) {
                System.out.println("Kota ke-" + (i + 1) + ":");
                for (int j = 0; j < hari; j++) {
                    System.out.print("  Hari " + (j + 1) + ": ");
                    suhu[i][j] = scanner.nextDouble();
                }
            }

            // Tampilkan data suhu dalam bentuk tabel
            System.out.println("\nData Suhu Udara (°C):");
            System.out.print("Kota/Hari\t");
            for (int j = 0; j < hari; j++) {
                System.out.print("Hari " + (j + 1) + "\t");
            }
            System.out.println();

            for (int i = 0; i < kota; i++) {
                System.out.print("Kota " + (i + 1) + "\t\t");
                for (int j = 0; j < hari; j++) {
                    System.out.print(suhu[i][j] + "\t");
                }
                System.out.println();
            }

            scanner.close();
        }
    }
