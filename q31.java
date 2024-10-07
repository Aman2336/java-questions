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

public class q31 {
    static int preindex = 0;
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

    static int find(int[] in, int e) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == e) {
                return i;
            }
        }
        return -1;
    }

    static node solve(int[] pre, int[] in, int s, int e, int preindex) {
        if (preindex >= pre.length || s > e) {
            return null;
        }
        int element = pre[preindex];
        preindex++;
        node root = new node(element);
        int pos = find(in, element);
        root.left = solve(pre, in, s, pos - 1, preindex);
        root.right = solve(pre, in, pos + 1, e, preindex);
        return root;
    }

    static node buildtree(int[] pre, int[] in) {
        int n = pre.length;
        preindex = 0;
        node root = solve(pre, in, 0, n - 1, preindex);
        return root;
    }

    public static void main(String[] args) {
        int pre[] = { 0, 1, 3, 4, 2, 5 };
        int in[] = { 3, 1, 4, 0, 5, 2 };
        node root = buildtree(in, pre);
        System.out.print('\n');
        levelorder(root);
    }

}
