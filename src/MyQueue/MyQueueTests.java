package MyQueue;

public class MyQueueTests {
    public static void main(String[] args) {

        MyQueue<Object> queue = new MyQueue<>();

        queue.add("element1");
        queue.add("element2");
        queue.add("element3");

        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue peek: " + queue.peek());

        System.out.println("Queue poll: " + queue.poll());

        System.out.println("Queue size: " + queue.size());

        queue.clear();
        System.out.println("Queue size: " + queue.size());
    }
}