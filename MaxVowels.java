package leetcode;

import java.util.*;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        char[] v = {'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> vowel = new HashSet<>();
        for (char vow : v) {
            vowel.add(vow);
        }
        int n = s.length();
        char c;
        if (k > n) k = n;


        int amt = 0;
        for (int i = 0; i < k; i++) {
            c = s.charAt(i);
            if (vowel.contains(c)) {
                amt++;
            }
        }

        int res = amt;
        for (int i = k; i < n; i++) {
            c = s.charAt(i);
            if (vowel.contains(c)) {
                amt++;
            }
            c = s.charAt(i-k);
            if (vowel.contains(c)) {
                amt--;
            }
            res = Math.max(res, amt);
        }

        return res;
    }
}
