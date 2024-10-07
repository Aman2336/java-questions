//basic intro for binary trees
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

public class q26 {
    static node takeinput(node root) {
        Scanner sn = new Scanner(System.in);
        int data = sn.nextInt();
        root = new node(data);
        if (data == -1) {
            return null;
        }
        root.left = takeinput(root.left);
        root.right = takeinput(root.right);
        return root;
    }

    static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    static void postorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
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

    static int max(int a, int b) {
        if (a > b)
            return a;

        else
            return b;
    }

    static int height(node root) {
        if (root == null) {
            return 0;
        }
        int leftans = height(root.left);
        int rightans = height(root.right);
        return 1 + max(leftans, rightans);
    }

    static int diameter(node root) {
        if (root == null) {
            return 0;
        }
        int one = diameter(root.left);
        int two = diameter(root.right);
        int three = height(root.left) + height(root.right) + 1;
        int ans1 = max(one,two);
        int ans2 = max(ans1,three);
        return ans2; 
    }

    public static void main(String[] args) {
        node root = null;
        root = takeinput(root);
        System.out.print('\n');
        levelorder(root);
        System.out.print('\n');
        preorder(root);
        System.out.print('\n');
        inorder(root);
        System.out.print('\n');
        postorder(root);
        System.out.println('\n');
        System.out.println(height(root));
        System.out.println('\n');
        System.out.println(diameter(root));
    }
}
/*
 * 1
 * 2
 * 3
 * 4
 * -1
 * -1
 * -1
 * 5
 * -1
 * -1
 * 6
 * 7
 * -1
 * -1
 * 8
 * -1
 * -1
 */