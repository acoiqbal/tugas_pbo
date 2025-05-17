import java.util.HashSet;
import java.util.Scanner;

public class NIMMahasiswaSet {
    public static void main(String[] args) {
        HashSet<String> nimSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Masukkan NIM Mahasiswa (Ketik 'selesai' untuk berhenti):");
        
        while (true) {
            System.out.print("NIM: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("selesai")) {
                break;
            }

            // Menambahkan NIM ke HashSet
            if (nimSet.add(input)) {
                System.out.println("NIM berhasil ditambahkan.");
            } else {
                System.out.println("NIM sudah ada! Tidak ditambahkan.");
            }
        }

        // Tampilkan semua NIM
        System.out.println("\nDaftar NIM Mahasiswa:");
        for (String nim : nimSet) {
            System.out.println(nim);
        }

        scanner.close();
    }
}
