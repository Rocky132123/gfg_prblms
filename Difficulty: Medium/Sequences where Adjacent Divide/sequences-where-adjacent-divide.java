class Solution {
    public int count(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // Base case
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }

        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int last = 1; last <= m; last++) {
                for (int prev = 1; prev <= m; prev++) {
                    if (prev % last == 0 || last % prev == 0) {
                        dp[len][last] += dp[len - 1][prev];
                    }
                }
            }
        }

        // Calculate answer
        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans += dp[n][j];
        }

        return ans;
    }
}