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

public class q14 {
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

    public static node removeduplicates1(node head) {
        // for sorted lists
        if (head == null) {
            return head;
        }
        node temp = head;
        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                node n = temp.next;
                node n_next = temp.next.next;
                n.next = null;
                temp.next = n_next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static node removeduplicates2(node head) {
        //for unsorted ll
        if (head == null) {
            return null;
        }
        node curr = head;
        node forw = null;

        while (curr != null) {
            forw = curr.next;

            while (forw != null) {
                if (forw.data == curr.data) {
                    forw.next = forw.next.next;
                } else {
                    forw = forw.next;
                }
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // node head1 = takeinput();
        // System.out.print('\n');
        // print(head1);
        // node ans = removeduplicates1(head1);
        // System.out.print('\n');
        // print(ans);
        // System.out.print('\n');
        node head2 = takeinput();
        System.out.print('\n');
        print(head2);
        node ans2 = removeduplicates2(head2);
        System.out.print('\n');
        print(ans2);
    }
}
