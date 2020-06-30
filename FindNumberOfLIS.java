package leetcode;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int res = 0;
        int maxLen = 0;
        int i, j;
        int n = nums.length;
        int[] dp = new int[n];
        int[] dpAmt = new int[n];

        for (i = 0; i < n; i++) {
            int len = 1;
            int amt = 1;
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len < dp[j] + 1) {
                        len = dp[j] + 1;
                        amt = dpAmt[j];
                    }
                    else if (len == dp[j] + 1) {
                        amt += dpAmt[j];
                    }
                }
            }
            dp[i] = len;
            dpAmt[i] = amt;
        }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.toString(dpAmt));
        for (int k = 0; k < n; k++) {
            if (dp[k] > maxLen) {
                maxLen = dp[k];
                res = dpAmt[k];
            }
            else if (dp[k] == maxLen) {
                res += dpAmt[k];
            }
        }
        return res;
    }
}
