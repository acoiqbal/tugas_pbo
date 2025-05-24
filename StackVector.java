package No5;

import java.util.Vector;

public class StackVector {
    Vector<Integer> data = new Vector<Integer>();
    public void push(int value) {
        data.add(value);
    }
    public int peek() {
        int value = data.get(data.size() - 1);
        return value;
    }
    public int pop() {
        int value = data.get(data.size() - 1);
        data.remove(data.get(data.size() - 1));
        return value;
    }
    public boolean empty() {
        return data.isEmpty();
    }
    @Override
    public String toString() {
        return data + "";
    }
}