public class CustomVector<E> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Konstruktor
    public CustomVector() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Menambahkan elemen
    public synchronized void add(E e) {
        ensureCapacity();
        data[size++] = e;
    }

    // Menghapus semua elemen
    public synchronized void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Mendapatkan elemen berdasarkan index
    public synchronized E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    // Menghapus elemen pada index tertentu
    public synchronized E remove(int index) {
        checkIndex(index);
        E removed = (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removed;
    }

    // Mengatur elemen pada index tertentu
    public synchronized void set(int index, E element) {
        checkIndex(index);
        data[index] = element;
    }

    // Mengecek apakah kosong
    public synchronized boolean isEmpty() {
        return size == 0;
    }

    // Mendapatkan ukuran
    public synchronized int size() {
        return size;
    }

    // Tampilkan isi
    @Override
    public synchronized String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Memastikan kapasitas cukup
    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Mengecek validitas index
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Main: uji coba
    public static void main(String[] args) {
        CustomVector<Object> v = new CustomVector<>();
        v.add(12);
        v.add("Gajah");
        v.add('#');

        System.out.println("Isi vector: " + v);
        System.out.println("Elemen ke-1: " + v.get(1));

        v.set(1, "Jerapah");
        System.out.println("Set index 1: " + v);

        v.remove(0);
        System.out.println("Setelah remove: " + v);

        System.out.println("Size: " + v.size());
        System.out.println("Is Empty: " + v.isEmpty());

        v.clear();
        System.out.println("Setelah clear: " + v);
    }
}
