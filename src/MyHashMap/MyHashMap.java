package MyHashMap;

public class MyHashMap<K, V> {
    private Node<K, V>[] table;
    private int size;
    private final double LOAD_FACTOR = 0.5;

    public MyHashMap() {
        table = new Node[10];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null)
            return;
        if (size >= LOAD_FACTOR * table.length)
            resize();
        Node<K, V> newNode = new Node<>(key, value);
        int index = getIndex(key);
        Node<K, V> existingNode = table[index];
        Node<K, V> prevNode = null;
        while (existingNode != null) {
            if (existingNode.key.equals(key)) {
                existingNode.value = value;
                return;
            }
            prevNode = existingNode;
            existingNode = existingNode.next;
        }
        if (prevNode != null) {
            prevNode.next = newNode;
        } else {
            table[index] = newNode;
        }
        size++;
    }

    public void remove(K key) {
        if (key == null) return;
        int index = getIndex(key);
        Node<K, V> existingNode = table[index];
        Node<K, V> prevNode = null;
        while (existingNode != null) {
            if (existingNode.key.equals(key)) {
                if (prevNode != null) {
                    prevNode.next = existingNode.next;
                } else {
                    table[index] = existingNode.next;
                }
                size--;
                return;
            }
            prevNode = existingNode;
            existingNode = existingNode.next;
        }
    }

    public void clear() {
        table = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> existingNode = table[index];
        while (existingNode != null) {
            if (existingNode.key.equals(key)) {
                return existingNode.value;
            }
            existingNode = existingNode.next;
        }
        return null;
    }

    private int getIndex(K key) {
        return key.hashCode() % table.length;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}