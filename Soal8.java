import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataMahasiswaMap {
    public static void main(String[] args) {
        HashMap<String, String> mahasiswaMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String nim, nama;

        System.out.println("Masukkan data mahasiswa (ketik 'selesai' untuk berhenti):");

        while (true) {
            System.out.print("NIM: ");
            nim = scanner.nextLine();
            if (nim.equalsIgnoreCase("selesai")) break;

            System.out.print("Nama: ");
            nama = scanner.nextLine();
            if (nama.equalsIgnoreCase("selesai")) break;

            mahasiswaMap.put(nim, nama);
            System.out.println("Data berhasil ditambahkan.\n");
        }

        // Tampilkan seluruh data mahasiswa
        System.out.println("\nData Mahasiswa:");
        for (Map.Entry<String, String> entry : mahasiswaMap.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + " | Nama: " + entry.getValue());
        }

        scanner.close();
    }
}
