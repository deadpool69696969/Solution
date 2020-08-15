import java.util.*;

public class TCS_CodeVita2020 {

    public static String longestSubString(String input) {
        if (input == null || input.length() < 1) {
            return "";
        }
        if (input.length() == 2 && input.charAt(0) != input.charAt(1)) {
            return String.valueOf(input.charAt(0));
        }
        if (input.length() == 1) {
            return String.valueOf(input.charAt(0));
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < input.length(); i++) {
            
            int len1 = expandFromMiddle(input, i, i);
            int len2 = 0;
            if ((i + 1) < input.length()) {
                len2 = expandFromMiddle(input, i, i + 1);
            }
            int len = Math.max(len1, len2);

            if (len > end - start) {

                start = i - ((len - 1) / 2);

                end = i + (len / 2);
            }
        }
        String Output = "";
      
        try {
            Output = input.substring(start, end + 1);
        } catch (Exception e) {
            Output = "";
        }
        return Output;
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static String[] Solution(String input) {
        String[] arr = new String[3];
        if (input.isEmpty() || input == null) {
            System.out.println("Impossible");
            return null;
        } else {
            String value = longestSubString(input);

            if (value.equals(input) || value.length() == input.length()) {
                arr[0] = String.valueOf(input.charAt(0));
                arr[1] = String.valueOf(input.substring(1, input.length() - 1));
                arr[2] = String.valueOf(input.charAt(input.length() - 1));

                input = input.replace(value, "");
            } else {
                arr[0] = value;
                if ("".equals(value)) {
                    System.out.println("Impossible");
                    return null;
                }
                input = input.replace(value, "");

                value = longestSubString(input);
                arr[1] = value;
                if ("".equals(value)) {
                    System.out.println("Impossible");
                    return null;
                }
                input = input.replace(value, "");

                value = longestSubString(input);
                arr[2] = value;
                if ("".equals(value)) {
                    System.out.println("Impossible");
                    return null;
                }
                input = input.replace(value, "");
            }
        }
        if (input.isEmpty() || input == null || input.equals("")) {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
        } else {
             System.out.println("Impossible");
            return null;
        }
        return arr;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
       try{
        Solution(input);
       }catch(Exception e){
       }
    }
}
