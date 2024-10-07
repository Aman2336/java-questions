//zigzag traversal
import java.util.*;

class node {
    public int data;
    public node left;
    public node right;

    public node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class q28 {
    static node takeinput(Scanner sn) {

        int data = sn.nextInt();
        if (data == -1) {
            return null;
        }
        node root = new node(data);
        root.left = takeinput(sn);
        root.right = takeinput(sn);
        return root;
    }

    static void levelorder(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            node front = q.peek();
            q.remove();
            if (front == null) {
                System.out.print('\n');
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }
    }

    static ArrayList<Integer> zigzag(node root) {
        Queue<node> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                node front = q.peek();
                q.remove();
                if (flag) {
                    temp.add(front.data);
                } else {
                    temp.add(0, front.data);
                }
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            flag = !flag;
            ans.addAll(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        node root = null;
        Scanner sn = new Scanner(System.in);
        root = takeinput(sn);
        System.out.print('\n');
        levelorder(root);
        ArrayList<Integer> arr = zigzag(root);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}