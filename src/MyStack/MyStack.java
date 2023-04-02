package MyStack;

public class MyStack<T> {
    private T[] stack;
    private int size;

    public MyStack() {
        stack = (T[]) new Object[10];
        size = 0;
    }

    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null value is not allowed");
        }
        if (size == stack.length) {
            T[] newStack = (T[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[size++] = value;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        T removedElement = stack[index];
        System.arraycopy(stack, index + 1, stack, index, size - index - 1);
        stack[--size] = null;
        return removedElement;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            stack[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }
        return stack[size - 1];
    }

    public T pop() {
        T topElement = peek();
        if (topElement != null) {
            stack[--size] = null;
        }
        return topElement;
    }
}