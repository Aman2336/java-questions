
//add 2 no.s represented by ll
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

public class q17 {
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

    public static node reverse(node head) {
        if (head == null) {
            return null;
        }
        node curr = head;
        node prev = null;
        node forw = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static node add2no(node head1, node head2) {
        if (head1 == null) {
            return head1;
        }
        if (head2 == null) {
            return head2;
        }
        node temp1 = reverse(head1);
        node temp2 = reverse(head2);
        int carry = 0;
        node anshead = null;
        node anstail = null;
        while (temp1 != null && temp2 != null) {
            int sum = temp1.data + temp2.data + carry;
            carry = sum / 10;
            int digit = sum % 10;
            node n = new node(digit);
            if (anshead == null) {
                anshead = n;
                anstail = n;
            }
            else{
                anstail.next = n;
                anstail = n;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null ) {
            int sum = temp1.data + carry;
            carry = sum / 10;
            int digit = sum % 10;
            node n = new node(digit);
            if (anshead == null) {
                anshead = n;
                anstail = n;
            }
            else{
                anstail.next = n;
                anstail = n;
            }
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            int sum = temp2.data + carry;
            carry = sum / 10;
            int digit = sum % 10;
            node n = new node(digit);
            if (anshead == null) {
                anshead = n;
                anstail = n;
            }
            else{
                anstail.next = n;
                anstail = n;
            }
            temp2 = temp2.next;
        }

        while (carry!=0) {
            int sum = carry;
            carry = sum / 10;
            int digit = sum % 10;
            node n = new node(digit);
            if (anshead == null) {
                anshead = n;
                anstail = n;
            }
            else{
                anstail.next = n;
                anstail = n;
            }
        }
        return reverse(anshead);
    }

    public static void main(String[] args) {
        node head1 = takeinput();
        node head2 = takeinput();
        System.out.print('\n');
        node ans = add2no(head1, head2);
        print(ans);
        System.out.print('\n');

    }
}
