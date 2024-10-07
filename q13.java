
//start node of the loop in ll and removing the loop
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

public class q13 {
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
    public static node iscycle2(node head) {
        //floyd cycle
        if (head == null) {
            return head;
        }
        node slow = head;
        node fast = head;
        while(slow != null && fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;
            if(slow == fast)
            {
                return slow;
            }
        }
        return null;
    }

    public static node startnode(node head){
        if(head == null){
            return null;
        }
        node slow = head;
        node intersection = iscycle2(head);
        while(slow!=intersection){
            slow = slow.next;
            intersection = intersection.next;
        }
        return slow;
    }
    public static void removeloop(node head){
        if(head == null){
            return;
        }
        node start = startnode(head);
        node temp = start;
        while (temp.next != start) {
            temp = temp.next;
        }
        temp.next = null;
    }
    public static void main(String[] args) {
        node n1 = new node(10);
        node n2 = new node(20);
        node n3 = new node(30);
        node n4 = new node(40);
        node n5 = new node(50);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        node head = n1;
        System.out.println(startnode(head).data);
        removeloop(head);
        System.out.println('\n');
        print(head);
    }
}
