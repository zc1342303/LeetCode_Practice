package leetcode;

import java.util.*;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> ans = new ArrayList<>();
        int maxAmt = 0;
        for (int i = 0; i < n; i++) {
            maxAmt = Math.max(maxAmt, candies[i]);
        }
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= maxAmt) {
                ans.add(true);
            }
            else {
                ans.add(false);
            }
        }
        return ans;
    }
}
