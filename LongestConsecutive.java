package leetcode;

import java.util.*;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int res = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num-1)) {
                continue;
            }
            for (int curr = num; ; curr++) {
                if (!set.contains(curr)) {
                    res = Math.max(res, curr - num);
                    break;
                }
            }
        }
        return res;
    }
}
