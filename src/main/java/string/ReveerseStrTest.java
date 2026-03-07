package string;

public class ReveerseStrTest {
    public static void main(String[] args) {
       var result = reverseString("abhishek");
        System.out.println(result);
    }

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
