package practice;

import java.util.*;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        int jLen = J.length();
        int sLen = S.length();
        Set<Character> jSet = new HashSet<>();

        for (int i = 0; i < jLen; i++) {
            char j = J.charAt(i);
            jSet.add(j);
        }

        for (int i = 0; i < sLen; i++) {
            char c = S.charAt(i);
            if (jSet.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        NumJewelsInStones solution = new NumJewelsInStones();
        int ans = solution.numJewelsInStones(J, S);
        System.out.println(ans);
    }
}
