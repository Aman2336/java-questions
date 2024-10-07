//queues
//reverse a queue
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class q24 {
    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int num = q.peek();
        q.remove();
        reverse(q);
        q.add(num);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        // reverse a queue
        reverse(q);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
