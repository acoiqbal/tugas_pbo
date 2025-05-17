import java.util.Vector;

public class VectorBubbleSort {
    public static void main(String[] args) {
        // Simpan 10 bilangan ke dalam Vector
        Vector<Integer> angka = new Vector<>();
        angka.add(45);
        angka.add(12);
        angka.add(78);
        angka.add(3);
        angka.add(56);
        angka.add(90);
        angka.add(33);
        angka.add(1);
        angka.add(27);
        angka.add(10);

        // Bubble Sort Ascending
        for (int i = 0; i < angka.size() - 1; i++) {
            for (int j = 0; j < angka.size() - i - 1; j++) {
                if (angka.get(j) > angka.get(j + 1)) {
                    // Swap elemen
                    int temp = angka.get(j);
                    angka.set(j, angka.get(j + 1));
                    angka.set(j + 1, temp);
                }
            }
        }

        // Tampilkan hasil setelah diurutkan
        System.out.println("Vector setelah diurutkan (Ascending):");
        for (int i = 0; i < angka.size(); i++) {
            System.out.print(angka.get(i) + " ");
        }
    }
}
