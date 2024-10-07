
//lca of two nodes , count no. of paths having sum 'k',kth ancestor
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

public class q30 {
    static int count = 0;
    static int k = 0;
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

    static void solve(node root, ArrayList<Integer> path, int k) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                count++;
            }
        }
        solve(root.left, path, k);
        solve(root.right, path, k);

        path.remove(path.size() - 1);
    }

    static int ksum(node root, int k) {
        count = 0;
        ArrayList<Integer> path = new ArrayList<>();
        solve(root, path, k);
        return count;
    }

    static node lca(node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }
        node leftans = lca(root.left, a, b);
        node rightans = lca(root.right, a, b);

        if (leftans != null && rightans != null) {
            return root;
        } else if (leftans == null && rightans != null) {
            return rightans;
        } else if (leftans != null && rightans == null) {
            return leftans;
        } else {
            return null;
        }
    }

    static node kthancestor(node root, int val, int n) {
        k = val;
        if (root == null) {
            return root;
        }
        if (root.data == n) {
            return root;
        }
        node leftans = kthancestor(root.left, k, n);
        node rightans = kthancestor(root.right, k, n);
        if (leftans != null && rightans == null) {
            k--;
            if (k <= 0) {
                k = 1234567890;
                return root;
            }
            return leftans;
        }
        if (rightans != null && leftans == null) {
            k--;
            if (k <= 0) {
                k = 1234567890;
                return root;
            }
            return rightans;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        node root = takeinput(sn);
        System.out.print("\n");
        levelorder(root);
        // node ans = lca(root, 5, 6);
        // System.out.println(ans.data);
        // int ans = ksum(root, 10);
        // System.out.println("no of paths are - " + ans);
        System.out.print("\n");
        System.out.println(kthancestor(root, 2, 9).data);

    }
}
