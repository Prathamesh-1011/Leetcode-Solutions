class Solution {
    public int findTargetSumWays(int[] nums, int tar) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum - tar < 0) return 0;
        if ((sum - tar) % 2 != 0) return 0;

        int k = (sum - tar) / 2;

        int[][] dp = new int[n][k + 1];

        // Base case
        if (nums[0] == 0) dp[0][0] = 2; // two ways: pick or not pick
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= k) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= k; t++) {
                int notTake = dp[i - 1][t];
                int take = 0;
                if (nums[i] <= t) take = dp[i - 1][t - nums[i]];
                dp[i][t] = notTake + take;
            }
        }
        return dp[n - 1][k];
    }
}
