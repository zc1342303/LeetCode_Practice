package practice;

public class ValidPalindrome {
    public boolean palindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (palindrome(s, i+1, j)) {
                return true;
            }

            if (palindrome(s, i, j-1)) {
                return true;
            }

            return false;
        }
        return true;
    }

    public static void main(String [] args) {
        ValidPalindrome solution = new ValidPalindrome();
        String s = "abca";
        boolean ans = solution.validPalindrome(s);
        System.out.println(ans);
    }
}
