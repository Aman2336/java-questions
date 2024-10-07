//boundary traversal
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

public class q29 {
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

    static void leftpart(node root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        ans.add(root.data);
        if (root.left != null) {
            leftpart(root.left, ans);
        } else {
            leftpart(root.right, ans);
        }
    }

    static void rightpart(node root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            rightpart(root.right, ans);
        } else {
            rightpart(root.left, ans);
        }
        ans.add(root.data);
        
    }

    static void leaves(node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }
        leaves(root.left, ans);
        leaves(root.right, ans);
    }

    static ArrayList<Integer> boundary(node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.data);
        // left part;
        leftpart(root.left, ans);
        // leaves
        leaves(root.left, ans);
        leaves(root.right, ans);

        // right part
        rightpart(root.right, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        node root = takeinput(sn);
        System.out.print('\n');
        levelorder(root);
        ArrayList<Integer> ans = boundary(root);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
