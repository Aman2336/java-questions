
//reverse a string 
//note - in java strings are strictly immutable unlike in c++ in java once a string object is created
// it cannot be changed hence whenever we have to do any operations in strings we have to return a new string
import java.util.*;

public class q4 {
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String reverse(String str) {
        char arr[] = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = new String();
        Scanner sn = new Scanner(System.in);
        str = sn.nextLine();
        System.out.println(reverse(str));

    }
}
