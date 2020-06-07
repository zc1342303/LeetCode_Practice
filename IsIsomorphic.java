package practice;

import java.util.*;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        int i;
        Map<Character, Integer> sDict = new HashMap<>();
        Map<Character, Integer> tDict = new HashMap<>();

        for (i = 0; i < len; i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);

            if (!sDict.containsKey(sCh) && !tDict.containsKey(tCh)) {
                sDict.put(sCh, i);
                tDict.put(tCh, i);
            } else if (sDict.containsKey(sCh) && tDict.containsKey(tCh)) {
                if (sDict.get(sCh) != tDict.get(tCh)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
