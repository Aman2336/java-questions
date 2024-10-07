
//middle element ,cycle detection in ll
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

public class q12 {
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

    public static int getlength(node head) {
        int cnt = 0;
        node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static int mid(node head) {
        int l = getlength(head);
        node temp = head;
        int cnt = 0;
        while (temp.next != null && cnt < l / 2) {
            temp = temp.next;
            cnt++;
        }
        return temp.data;
    }

    public static boolean iscycle1(node head) {
        //using map
        if (head == null) {
            return false;
        }
        Map<node, Boolean> visited = new HashMap<>();
        node temp = head;
        while (temp != null) {
            if (visited.containsKey(temp)) {
                return true;
            }
            visited.put(temp, true);
            temp = temp.next;
        }
        return false;
    }
    
    public static boolean iscycle2(node head) {
        //floyd cycle
        if (head == null) {
            return false;
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
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        node head = takeinput();
        System.out.print('\n');
        print(head);
        System.out.print('\n');
        System.out.println(mid(head));
        node n1 = new node(10);
        node n2 = new node(20);
        node n3 = new node(30);
        node n4 = new node(40);
        node n5 = new node(50);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        node newhead = n1;
        if (iscycle2(newhead)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
