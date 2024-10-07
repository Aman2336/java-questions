// count for valid and max area histogram

import java.util.*;

public class q23 {
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static ArrayList<Integer> nextsmallerelement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(0);// placeholder
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans.set(i, st.peek());
            st.push(i);
        }
        return ans;
    }

    public static ArrayList<Integer> prevsmallerelement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(0);// placeholder
        }
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (st.peek() != -1 && arr[st.peek()] >= curr) {
                st.pop();
            }
            ans.set(i, st.peek());
            st.push(i);
        }
        return ans;
    }

    public static int area(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> next = new ArrayList<>(n);
        next = nextsmallerelement(arr);
        ArrayList<Integer> prev = new ArrayList<>(n);
        prev = prevsmallerelement(arr);

        int maxarea = -1;
        for (int i = 0; i < n; i++) {
            int l = arr[i];
            if (next.get(i) == -1) {
                next.set(i, n);
            }
            int b = next.get(i) - prev.get(i) - 1;
            int area = l * b;
            maxarea = max(area, maxarea);
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(area(arr));
    }
}
