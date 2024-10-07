import java.util.*;

//reverse first k elements in queue
// first negative in every k size window
public class q25 {
    public static void reversefirstk(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.add(q.peek());
            q.remove();
        }
        while (!st.empty()) {
            q.add(st.peek());
            st.pop();
        }
        int t = q.size() - k;
        while (t > 0) {
            int val = q.peek();
            q.remove();
            q.add(val);
            t--;
        }
    }

    public static ArrayList<Integer> firstnegink(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dq.push(i);
            }
        }
        if (dq.size() > 0) {
            ans.add(arr[dq.peek()]);
        } else {
            ans.add(0);
        }

        for (int i = k; i < arr.length; i++) {
            if (!dq.isEmpty() && i - dq.peek() >= k) {
                dq.removeFirst();
            }
            if (arr[i] < 0) {
                dq.addLast(i);
            }

            if (dq.size() > 0) {
                ans.add(arr[dq.peek()]);
            } else {
                ans.add(0);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // Scanner sn = new Scanner(System.in);
        // int k = sn.nextInt();
        // reversefirstk(q, k);
        // while (!q.isEmpty()) {
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }
        int arr[] = { -8, 2, 3, -6, 10 };
        ArrayList<Integer> ans = firstnegink(arr, 2);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
