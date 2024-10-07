//add 2 no represented by arrays
import java.util.*;

public class main {
    public static ArrayList<Integer> add2no(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = n1 - 1;
        int j = n2 - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = arr1[i] + arr2[j] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = arr1[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
        }
        while (j >= 0) {
            int sum = arr2[j] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            j--;
        }
        while (carry != 0) {
            int sum = carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        Scanner sn = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int a = sn.nextInt();
            arr1[i] = a;
        }
        for (int i = 0; i < 3; i++) {
            int a = sn.nextInt();
            arr2[i] = a;
        }
        ArrayList<Integer> ans = add2no(arr1, arr2);
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }
    }
};