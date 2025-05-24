package No6;

import java.util.LinkedList;

public class QueueLinkedList {
    LinkedList<Integer> data = new LinkedList<>();

    public void offer(int value) {
        data.add(value);
    }
    public int peek() {
        int value = data.get(0);
        return value;
    }
    public int poll() {
        int value = data.get(0);
        data.remove(0);
        return value;
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
