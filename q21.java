//redundant brackets
import java.util.Scanner;
import java.util.Stack;

public class q21 {
    public static boolean redundant(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(') {
                st.push(ch);
            } else {
                if (ch == ')') {
                    boolean isred = true;
                    while (st.peek() != '(') {
                        if (st.peek() == '+' || st.peek() == '-' || st.peek() == '*' || st.peek() == '/'
                                || st.peek() == '(') {
                            isred = false;
                        }
                        st.pop();
                    }
                    if (isred) {
                        return true;
                    } else {
                        st.pop();
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str = new String();
        str = sn.nextLine();
        if (redundant(str)) {
            System.out.print("true");
        } else {
            System.out.println("false");
        }
    }
}
