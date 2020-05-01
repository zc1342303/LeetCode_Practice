package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring (String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int n = s.length();

        for (int j = 0; j < n; j++) {
            if (set.contains(s.charAt(j))) {
                while (s.charAt(j) != s.charAt(i)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            set.add(s.charAt(j));
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "aaca";
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int ans = solution.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }


}
