class Solution {
    public int change(int T, int[] arr) {
        int n = arr.length;
        int dp[][] = new int [n][T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][T];
    }
}