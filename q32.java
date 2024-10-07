
//bst
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

public class q32 {
    static node insertintobst(node root, int data) {
        if (root == null) {
            root = new node(data);
            return root;
        }
        if (root.data < data) {
            root.right = insertintobst(root.right, data);
        } else {
            root.left = insertintobst(root.left, data);
        }
        return root;
    }

    static node takeinput(Scanner sn, node root) {
        int data = sn.nextInt();
        while (data != -1) {
            root = insertintobst(root, data);
            data = sn.nextInt();
        }
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

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        node root = null;
        root = takeinput(sn, root);
        System.out.print('\n');
        levelorder(root);

    }
}
