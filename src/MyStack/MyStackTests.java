package MyStack;

public class MyStackTests {
    public static void main(String[] args) {

        MyStack<Object> stack = new MyStack<>();

        stack.push("element 1");
        stack.push("element 2");
        stack.push("element 3");

        System.out.println("Size: " + stack.size());

        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());

        stack.clear();
        System.out.println("Size: " + stack.size());
    }
}