package MyArrayList;

public class MyArrayListTests {

    public static void main(String[] args) {

        MyArrayList<Object> list = new MyArrayList<>();

        list.add("first");
        list.add("second");
        list.add("third");

        System.out.println("Size: " + list.size());

        System.out.println("Value at index: " + list.get(1));

        list.remove(1);
        System.out.println("Value at index after removal: " + list.get(1));

        list.clear();
        System.out.println("Size after clearing: " + list.size());
    }
}