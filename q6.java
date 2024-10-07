
//check if one string is permutation of other
import java.util.*;
import java.util.Scanner;

public class q6 {
    public static boolean checkequal(int count1[], int count2[]) {
        for (int i = 0; i < 128; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean ispermute(String str1, String str2) {
        int count1[] = new int[128];
        int count2[] = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            // int index = (int) (str1.charAt(i) - '0');
            count1[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            // int index = (int) (str2.charAt(i) - '0');
            count2[str2.charAt(i)]++;
        }
    //    int wsize = str2.length();
    //     int i = 0;
    //     while (i < wsize && i < str1.length()) {
    //         int n = (int) str1.charAt(i) - '0';
    //         count1[n]++;
    //         i++;
    //     }
    //     if (checkequal(count1, count2)) {
    //         return true;
    //     }
    //     while (i < str1.length()) {
    //         int index = (int) str1.charAt(i) - 'a';
    //         count1[index]++;

    //         index = (int) str1.charAt(i - wsize) - 'a';
    //         count1[index]++;
    //         i++;
    //     }
        if (checkequal(count1, count2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = new String();
        String str2 = new String();
        Scanner sn = new Scanner(System.in);
        str1 = sn.nextLine();
        str2 = sn.nextLine();

        if  (ispermute(str1, str2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
