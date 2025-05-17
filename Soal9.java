import java.util.ArrayList;
import java.util.Iterator;

public class DataMahasiswaArrayList {
    public static void main(String[] args) {
        // Buat ArrayList untuk menyimpan data NIM
        ArrayList<String> nimList = new ArrayList<>();

        // Tambahkan data NIM ke dalam ArrayList
        nimList.add("20231001");
        nimList.add("20231002");
        nimList.add("20231003");
        nimList.add("20231004");
        nimList.add("20231005");

        // Gunakan Iterator untuk menampilkan isi data satu per satu
        System.out.println("Daftar NIM Mahasiswa:");
        Iterator<String> iterator = nimList.iterator();
        while (iterator.hasNext()) {
            String nim = iterator.next();
            System.out.println(nim);
        }
    }
}
