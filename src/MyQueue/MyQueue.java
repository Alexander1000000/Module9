package MyQueue;

public class MyQueue<T> {
    private T[] array;
    private int first;
    private int last;
    private int size;

    public MyQueue() {
        array = (T[]) new Object[10];
        size = 0;
        first = 0;
        last = -1;
    }

    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        if (last == array.length - 1) {
            last = -1;
        }
        array[++last] = value;
        size++;
    }

    public void clear() {
        for (int i =0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        first = 0;
        last = -1;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return array[first];
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T value = array[first++];
        if (first == array.length) {
            first = 0;
        }
        size--;
        return value;
    }
}