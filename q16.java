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

public class q16 {
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

    public static node merge(node head1, node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        node curr1 = head1;
        node next1 = curr1.next;
        node curr2 = head2;
        node next2 = curr2.next;

        while (curr2 != null && next1 != null) {
            if (curr2.data <= next1.data && curr2.data >= curr1.data) {
                curr1.next = curr2;
                next2 = curr2.next;
                curr2.next = next1;
                curr1 = curr2;
                curr2 = next2;
            }
            else{
                curr1 = curr1.next;
                next1 = next1.next;
                if(next1 == null){
                    curr1.next = curr2;
                    return head1;
                }
            } 
        }
        return head1;
    }

    public static void main(String[] args) {
        node head1 = takeinput();
        node head2 = takeinput();
        System.out.print('\n');
        node ans = merge(head1, head2);
        print(ans);
    }
}
