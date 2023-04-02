package MyLinkedList;

public class MyLinkedList<T> {

    private Node first;
    private Node last;
    private int size;


    private class Node {
        private T value;
        private Node prev;
        private Node next;

        public Node(T value)  {
            if (value == null) {
                throw new IllegalArgumentException("Null elements are not allowed");
            }
            this.value = value;

            prev = null;
            next = null;
        }

        public T getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(T value) {
        Node node = new Node(value);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            last.setNext(node);
            node.setPrev(last);
            last = node;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node node = getNode(index);
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.setNext(nextNode);
            node.setPrev(null);
        }
        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.setPrev(prevNode);
            node.setNext(null);
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node node = getNode(index);
        return node.getValue();
    }

    private Node getNode(int index) {
        Node node;
        if (index <= size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrev();
            }
        }
        return node;
    }
}