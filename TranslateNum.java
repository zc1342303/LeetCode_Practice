package leetcode;

public class TranslateNum {
    public int translateNum(int num) {
        String str = Integer.toString(num);
        char[] s = str.toCharArray();
        int n = s.length;

        // 特判
        if (n == 1) return 1;
        if (n == 2) return (s[0] == '1' || (s[0] == '2' && s[1] <= '5')) ? 2 : 1;

        int[] dp = new int[n];

        // 边界条件
        dp[0] = 1;
        dp[1] = (s[0] == '1' || (s[0] == '2' && s[1] <= '5')) ? 2 : 1;

        // 主循环
        for (int i = 2; i < n; i++) {
            dp[i] += dp[i-1];
            if (s[i-1] == '1' || (s[i-1] == '2' && s[i] <= '5')) {
                dp[i] += dp[i-2];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
