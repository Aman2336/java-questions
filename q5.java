
//valid palindrome or not
import java.util.*;

public class q5 {
    public static String remove(String str) {
        //removing special characters
        String ans = new String();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                ans += ch;
            }
        }
        return ans;
    }
    public static String valid(String str){
        String ans = new String();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <='z'){
                ans+=ch;
            }
            else{
                char newch = (char)(ch - 'A' + 'a');
                ans+=newch;
            }
        }
        return ans;
    }
    public static boolean ispal(String str) {
        String newstr = remove(str);
        String temp = valid(newstr);
        int i = 0;
        int j = temp.length()-1;
        while(i<j){
            if(temp.charAt(i) == temp.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str = new String();
        str = sn.nextLine();
        if (ispal(str)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}