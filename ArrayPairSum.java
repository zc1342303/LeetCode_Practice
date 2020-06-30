package leetcode;

import java.util.*;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int m = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }
}
