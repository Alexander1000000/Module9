package MyArrayList;

public class MyArrayList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[10];
        this.size = 0;
    }

    public void add(T value) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        if (value == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        data[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds " + index);
        }
        return (T) data[index];
    }
}