package leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int len = 0;
        String res = "";
        int l, r;
        for (int mid = 0; mid < n; mid++) {
            // odd
            l = mid;
            r = mid;
            while(l-1 >= 0 && r+1 < n && s.charAt(l-1) == s.charAt(r+1)) {
                l--;
                r++;
            }
            len = r - l + 1;
            if (len > maxLen) {
                maxLen = len;
                res = s.substring(l, r+1);
            }
            // even
            l = mid+1;
            r = mid;
            while(l-1 >= 0 && r+1 < n && s.charAt(l-1) == s.charAt(r+1)) {
                l--;
                r++;
            }
            len = r - l + 1;
            if (len > maxLen) {
                maxLen = len;
                res = s.substring(l, r+1);
            }
        }

        return res;
    }
}
