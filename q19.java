//stacks
//reverse a stack and push at bottom using stack

import java.util.Scanner;
import java.util.Stack;

public class q19 {
    public static void print(Stack<Integer> st){
        while(!st.empty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
    public static void pushatbottom(Stack<Integer> st,int data){
        if(st.empty() == true){
            st.push(data);
            return;
        }
        int top = st.peek();
        st.pop();
        pushatbottom(st, data);
        st.push(top);
    }
    public static void main(String[] args) {
        // Stack<Character> st = new Stack<>();
        // Scanner sn = new Scanner(System.in);
        // String str = new String();
        // str = sn.nextLine();
        // for (int i = 0; i < str.length(); i++) {
        //     st.push(str.charAt(i));
        // }
        // String ans = new String();
        // while (!st.empty()) {
        //     char ch = st.peek();
        //     st.pop();
        //     ans += ch;
        // }
        // System.out.println(ans);
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        // print(st);
        System.out.print('\n');
        pushatbottom(st,6);
        print(st);
        System.out.print('\n');
    }
}
