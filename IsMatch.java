package practice;

public class IsMatch {
    boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        dp = new boolean[m+1][n+1];
        char charS = '#', charP = '#';
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // pi为p字符的位置, si为s字符的位置
                int pi = i - 1;
                int si = j - 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                else if (i == 0) {
                    dp[i][j] = false;
                }
                else if (dp[i][j]) {
                    dp[i][j] = true;
                }
                else if (p.charAt(pi) == '*') {
                    if (dp[i-2][j]) {
                        dp[i][j] = true;
                        char patChar = p.charAt(pi-1);
                        for (int k = j + 1; k <= n; k++) {
                            if (patChar == '.' || patChar == s.charAt(k-1)) {
                                dp[i][k] = true;
                            } else {
                                break;
                            }
                        }
                    }
                }
                else if (j == 0) {
                    dp[i][j] = false;
                }
                else if (p.charAt(pi) == '.' && dp[i-1][j-1]) {
                    dp[i][j] = true;
                }
                else if (p.charAt(pi) == s.charAt(si) && dp[i-1][j-1]) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = false;
                }
                // System.out.print(dp[i][j]);
                // System.out.print(' ');
            }
            // System.out.print('\n');
        }
        return dp[m][n];
    }
}
