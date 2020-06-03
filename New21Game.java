package practice;

public class New21Game {
    // ... 15 16 | 17 18 19 20 21 | 22 23 24 25 26 |
    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;

        int maxPoint = K + W;
        double[] dp = new double[maxPoint];
        double S = 0.0;
        for (int i = K; i <= N && i < maxPoint; i++) {
            dp[i] = 1.0;
        }
        S = N - K + 1;

        for (int i = K-1; i >= 0; i--) {
            dp[i] = S / W;
            S += dp[i];
            S -= dp[i+W];
        }

        return dp[0];
    }
}
