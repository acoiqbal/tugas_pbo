package No5;

public class StackArray {
    int top = -1;
    int max_size = 5;
    int[] data = new int[max_size];

    public Integer peek() {
        Integer result = null;
        if (top >= 0) {
            result = data[top];
        }
        return result;
    }

    public void push(int value) {
        top++;
        if (top >= max_size) {
            max_size += 10;
            int[] dataBaru = new int[max_size];
            for (int i = 0; i < data.length; i++) {
                dataBaru[i] = data[i];
            }
            data = dataBaru;
        }
        data[top] = value;
    }

    public Integer pop() {
        Integer result = null;
        if (!empty()) {
            int simpan = data[top];
            result = simpan;
            data[top] = 0;
            top--;
        }
        return result;
    }
    public boolean empty() {
        boolean result = false;
        if (top < 0) {
            result = true;
        }
        return result;
    }
    public String toString() {
        String isi = "[";
        for (int i = 0; i <= top; i++) {
            if (i > 0) {
                isi += ", ";
            }
            isi += data[i];
        }
        isi += "]";
        return isi;
    }
}