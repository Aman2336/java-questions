
//keypad problem
import java.util.*;

public class q10 {
    public static void solve(int i, ArrayList<String> ans, ArrayList<Character> output, String str, String[] arr) {
        if (i >= str.length()) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : output) {
                sb.append(ch);
            }
            ans.add(sb.toString());
            return;
        }
        String val = new String();
        val = arr[str.charAt(i) - '0'];
        for (int k = 0; k < val.length(); k++) {
            output.add(val.charAt(k));
            solve(i + 1, ans, output, str, arr);
            output.remove(output.size() - 1);
        }
    }

    public static ArrayList<String> keypad(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        int i = 0;
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Character> output = new ArrayList<>();
        solve(i, ans, output, str, arr);
        return ans;

    }

    public static void main(String[] args) {
        String str = new String();
        Scanner sn = new Scanner(System.in);
        str = sn.nextLine();
        ArrayList<String> ans = keypad(str);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
