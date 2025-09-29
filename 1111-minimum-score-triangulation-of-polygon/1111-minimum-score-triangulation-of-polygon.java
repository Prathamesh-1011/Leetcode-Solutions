class Solution {
    private int[][] dp;

    int solve(int[] values, int i, int k) {
        if (dp[i][k] != -1) return dp[i][k];
        if (k - i == 1) return dp[i][k] = 0;
        int minScore = Integer.MAX_VALUE;
        for (int j = i + 1; j < k; j++) {
            int score = (values[i] * values[j] * values[k]) + solve(values, i, j) + solve(values, j, k);
            minScore = Math.min(minScore, score);
        }
        return dp[i][k] = minScore;
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        int i = 0, k = n - 1;
        return solve(values, i, k);
    }
}