
//sort a stack and valid parenthesis
import java.util.Scanner;
import java.util.Stack;

public class q20 {
    public static void sortedinsert(Stack<Integer> st, int data) {
        if ((!st.empty() && st.peek() < data) || st.empty()) {
            st.push(data);
            return;
        }
        int top = st.peek();
        st.pop();
        sortedinsert(st, data);
        st.push(top);
    }

    public static void sort(Stack<Integer> st) {
        if (st.empty()) {
            return;
        }
        int top = st.peek();
        st.pop();

        sort(st);
        sortedinsert(st, top);
    }

    public static void print(Stack<Integer> st) {
        while (!st.empty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }

    public static boolean isvalid(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if ((ch == '}' && top != '{') || (ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        // Stack<Integer> st = new Stack();
        // st.push(10);
        // st.push(1);
        // st.push(3);
        // st.push(2);
        // st.push(9);
        // System.out.print('\n');
        // sort(st);
        // print(st);
        Scanner sn = new Scanner(System.in);
        String str = new String();
        str = sn.nextLine();
        if (isvalid(str)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
