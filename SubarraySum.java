package practice;

import java.util.*;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int amt = 0, prefixSumAmt, sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.get(sum - k) != null) {
                prefixSumAmt = map.get(sum - k);
                amt += prefixSumAmt;
            }
            int currNumAmt = map.get(sum) != null ? map.get(sum) : 0;
            map.put(sum, currNumAmt + 1);
        }
        return amt;
    }
}
