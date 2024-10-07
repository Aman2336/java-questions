import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class node {
    public int data;
    public node next;
    public node random;

    public node(int data) {
        this.data = data;
        next = null;
    }
}

public class q18pt2 {
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

    public static node clonell(node head) {
        if (head == null) {
            return null;
        }
        node clonehead = null;
        node clonetail = null;
        node temp = head;

        // step 1
        while (temp != null) {
            node n = new node(temp.data);
            if (clonehead == null) {
                clonehead = n;
                clonetail = n;
            } else {
                clonetail.next = n;
                clonetail = n;
            }
            temp = temp.next;
        }

        // step2
        temp = head;
        node temp1 = clonehead;

        while (temp != null && temp1 != null) {
            // for original ll
            node next1 = temp.next;
            temp.next = temp1;
            temp = next1;

            // for clone ll
            next1 = temp1.next;
            temp1.next = temp;
            temp1 = next1;
        }

        // step 3
        temp = head;
        temp1 = clonehead;

        while (temp != null) {
            if (temp.next != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                } else {
                    temp.next.random = temp.random;
                }
            }
            if (temp.next != null) {
                temp = temp.next.next;
            }
        }
        // step 4
        temp = head;
        temp1 = clonehead;

        while(temp != null && temp1 != null){
            temp.next = temp1.next;
            temp = temp.next;
            if(temp != null){
                temp1.next = temp.next;
            }
            temp1 = temp.next;
        }
        return clonehead;
    }

    public static void main(String[] args) {
        node n1 = new node(1);
        node n2 = new node(2);
        node n3 = new node(3);
        node n4 = new node(4);
        node n5 = new node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n2;
        n2.random = n1;
        n3.random = n2;
        n4.random = n3;
        n5.random = n3;
        node head = n1;
        print(head);
        System.out.print('\n');
        node ans = clonell(head);
        print(ans);
        System.out.print('\n');
    }
}
