class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
        for (int node = 2; node <= n; ++node) {
            for (int root = 1; root <= node; ++root) {
                int left = root - 1, right = node - root;
                dp[node] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}