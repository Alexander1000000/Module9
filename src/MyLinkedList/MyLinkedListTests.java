package MyLinkedList;

public class MyLinkedListTests {
    public static void main(String[] args) {

        MyLinkedList<Object> list = new MyLinkedList<>();

        list.add("first");
        list.add("second");
        list.add("third");

        System.out.println("List size: " + list.size());

        System.out.println("List elements:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(1);
        System.out.println("After removing the element:");

        System.out.println("List size: " + list.size());

        System.out.println("List elements:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.clear();
        System.out.println("After clearing the list:");
    }
}