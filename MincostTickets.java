package practice;

public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int m = days[n - 1];
        int[] valid = {1, 7, 30};
        int[] dayToIndex = new int[m + 1];

        // 初始化dayToIndex;
        int j = 0;
        dayToIndex[0] = -1;
        for (int i = 1; i <= m; i++) {
            if (i == days[j]) {
                j++;
            }
            dayToIndex[i] = j - 1;
        }

        int prev, index, tmp;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = (dayToIndex[i] + 1) * costs[0];
            for (j = 0; j < 3; j++) {
                tmp = Math.max(i - valid[j], 0);
                index = dayToIndex[tmp];
                prev = index < 0 ? 0 : days[index];
                dp[i] = Math.min(dp[i], dp[prev] + costs[j]);
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        int[] days = new int[] {1, 4, 6, 7, 8, 20};
        int[] costs = new int[] {2, 7, 15};

        MincostTickets solution = new MincostTickets();
        int ans = solution.mincostTickets(days, costs);
        System.out.println(ans);
    }
}
