package MyHashMap;

public class MyHashMapTests {
    public static void main(String[] args) {

        MyHashMap<Object, Object> map = new MyHashMap<>();

        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println(map.get("apple"));
        System.out.println(map.get("banana"));
        System.out.println(map.get("cherry"));

        map.remove("banana");

        System.out.println(map.size());

        map.clear();
        System.out.println(map.size());
    }
}