import java.util.ArrayList;
import java.util.Stack;

public class q22 {
    public static ArrayList<Integer> nextsmaller(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (st.peek() != -1 && curr <= st.peek()) {
                st.pop();
            }
            ans.set(i, st.peek());
            st.push(curr);
        }
        return ans;
    }
    public static ArrayList<Integer> prevsmaller(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (st.peek() != -1 && curr <= st.peek()) {
                st.pop();
            }
            ans.set(i, st.peek());
            st.push(curr);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        ArrayList<Integer> ans = nextsmaller(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
        ArrayList<Integer> ans2 = prevsmaller(arr);
        for (int i : ans2) {
            System.out.print(i + " ");
        }
    }
}
