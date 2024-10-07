//subsets of an array
import java.util.*;

public class q9 {
    public static void solve(int i, ArrayList<Integer> output, List<List<Integer>> ans, int[] arr, int n) {
        if (i >= n) {
            ans.add(new ArrayList<>(output));
            return;
        }
        solve(i + 1, output, ans, arr, n);
        output.add(arr[i]);
        solve(i + 1, output, ans, arr, n);
        output.remove(output.size() - 1);
    }

    public static List<List<Integer>> subsets(int[] arr) {
        int i = 0;
        int n = arr.length;
        ArrayList<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(i, output, ans, arr, n);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = subsets(arr);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print('\n');
        }
    }
}
