package leetcode;

public class MaxDotProduct {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1][n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = nums1[i] * nums2[j];
                }
                else if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j-1], nums1[i] * nums2[j]);
                }
                else if (j == 0) {
                    dp[i][j] = Math.max(dp[i-1][j], nums1[i] * nums2[j]);
                }
                else {
                    dp[i][j] = dp[i-1][j-1];
                    dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + nums1[i] * nums2[j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1-1][n2-1];
    }
}
