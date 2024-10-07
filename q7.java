//recursion

import java.util.Scanner;

public class q7 {
    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return n * fact(n - 1);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int climbstairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbstairs(n - 1) + climbstairs(n - 2);
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length-1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;

        } else {
            return isSorted(arr, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        // int n = sn.nextInt();
        // System.out.println(fact(n));
        // System.out.println(fib(n));
        // System.out.println(climbstairs(5));
        int arr[] = { 1, 6,3, 4, 5 };
        if (isSorted(arr, 0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
