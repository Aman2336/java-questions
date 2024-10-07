//merge 2 sorted arrays
public class q2 {
    static int[] merge2arrays(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        int ansindex = 0;
        int ans[] = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                ans[ansindex++] = arr1[i++];
            } else {
                ans[ansindex++] = arr2[j++];
            }
        }
        while (i < n1 && j < n2) {
            ans[ansindex++] = arr1[i++];
        }
        while (j < n2) {
            ans[ansindex++] = arr2[j++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 3, 4 };
        int arr2[] = { 1, 5, 6, 6 };
        int[] ans = merge2arrays(arr1, arr2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
