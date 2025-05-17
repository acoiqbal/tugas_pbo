public class CustomArrayList<E> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Konstruktor
    public CustomArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Menambah elemen di akhir
    public void add(E e) {
        ensureCapacity();
        data[size++] = e;
    }

    // Menghapus semua elemen
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Mengambil elemen pada index tertentu
    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    // Menghapus elemen pada index tertentu
    public E remove(int index) {
        checkIndex(index);
        E removed = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null; // hapus referensi
        return removed;
    }

    // Menetapkan elemen pada index tertentu
    public void set(int index, E element) {
        checkIndex(index);
        data[index] = element;
    }

    // Cek apakah list kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Mengembalikan jumlah elemen
    public int size() {
        return size;
    }

    // Tampilkan semua isi
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Periksa kapasitas array dan perluas jika penuh
    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Periksa index valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Main untuk uji coba
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Isi: " + list);
        System.out.println("Ukuran: " + list.size());
        System.out.println("Elemen ke-1: " + list.get(1));

        list.set(1, "Blueberry");
        System.out.println("Set indeks 1 jadi Blueberry: " + list);

        list.remove(0);
        System.out.println("Hapus indeks 0: " + list);

        list.clear();
        System.out.println("Setelah clear: " + list);
        System.out.println("Kosong? " + list.isEmpty());
    }
}
