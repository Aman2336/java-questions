//sort 0,1,2
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class node {
    public int data;
    public node next;

    public node(int data) {
        this.data = data;
        next = null;
    }
}

public class q15 {
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
    public static void insertatend(node head,int data){
        node n = new node(data);
        if(head == null){
            head = n;
        }
        else{
            node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }
    public static node sort012(node head){
        if(head == null){
            return null;
        }

        //creating three seperate ll
        node one = new node(-1);
        node zero = new node(-1);
        node two = new node(-1);

        node tail0 = zero;
        node tail1 = one;
        node tail2 = two;



        node temp = head;
        while(temp != null){
            if(temp.data == 1){
                insertatend(one,temp.data);
                tail1 = tail1.next;
            }
            else if(temp.data == 2){
                insertatend(two,temp.data);
                tail2 = tail2.next;
            }
            else{
                insertatend(zero,temp.data);
                tail0 = tail0.next;
            }
            temp = temp.next;
        }

        //merge three ll2
        if(one.next != null){
            tail0.next = one.next;
        }
        else{
            tail0.next = two.next;
        }

        tail1.next = two.next;
        tail2.next = null;
        head = zero.next;

        return head;
    }
    public static void main(String[] args) {
        node head = takeinput();
        System.out.print('\n');
        print(head);
        node ans = sort012(head);
        System.out.print('\n');
        print(ans);
    }
}
