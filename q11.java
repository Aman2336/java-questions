//linked list intro
//creation insertion ,deletion,reverse,reverse in k groups
import java.util.Scanner;



class node {
    public int data;
    public node next;

    public node(int data) {
        this.data = data;
        next = null;
    }
}

public class q11 {
    static public node takeinput() {
        int data;
        Scanner sn = new Scanner(System.in);
        data = sn.nextInt();
        node head = null;
        while (data != -1) {
            node n = new node(data);
            if (head == null) {
                head = n;
            } else {
                node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = n;
            }
            data = sn.nextInt();
        }
        return head;
    }

    static public void print(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static node revresell(node head){
        if(head == null){
            return head;
        }
        node curr = head;
        node forw = null;
        node prev = null;
        while(curr!=null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static node revresellink(node head,int k){
        if(head == null){
            return head;
        }
        node curr = head;
        node forw = null;
        node prev = null;
        int count = 0;
        while(curr!=null && count < k){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
            count++;
        }
        if(forw!= null){
            head.next = revresellink(forw, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        node head = takeinput();
        System.out.print("\n");
        print(head);
        node reverse = revresell(head);
        System.out.print("\n");
        print(reverse);
        node reversek = revresellink(reverse,2);
        System.out.print("\n");
        print(reversek);
    }
}
