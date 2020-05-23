package practice;

import java.util.*;

public class MinWindow {
    public String minWindow(String s, String t) {
        String res = "";
        int n = s.length();
        int times, formed = 0, i = 0;
        char c;
        Map<Character, Integer> pattern = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            c = t.charAt(k);
            if (pattern.containsKey(c)) {
                times = pattern.get(c);
                pattern.put(c, times + 1);
            }
            else {
                pattern.put(c, 1);
            }
        }

        for (int j = 0; j < n; j++) {
            c = s.charAt(j);
            if (!pattern.containsKey(c)) {
                continue;
            }

            times = pattern.get(c);
            pattern.put(c, times - 1);
            // 更新后, 该字母出现次数为0了, 满足了一个字母的条件, formed+1
            if (times - 1 == 0) {
                formed++;
            }
            while (formed == pattern.size() && i <= j) {
                if (res.equals("") || j - i + 1 < res.length()) {
                    res = s.substring(i, j+1);
                }
                c = s.charAt(i);
                if (pattern.containsKey(c)) {
                    times = pattern.get(c);
                    pattern.put(c, times + 1);
                    if (times + 1 == 1) {
                        formed -= 1;
                    }
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinWindow solution = new MinWindow();
        String s = "ABOBECODEBANC";
        String t = "ABC";
        String ans = solution.minWindow(s, t);
        System.out.println(ans);
    }
}
