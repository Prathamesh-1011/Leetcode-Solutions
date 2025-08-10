class Solution {
    public int coinChange(int[] arr, int tar) {
        int n = arr.length;
        int dp[][] = new int[n][tar+1];

        for(int i = 0; i <= tar; i++){
            if(i % arr[0] == 0){
                dp[0][i] = i/arr[0];
            } else{
                dp[0][i] = (int) Math.pow(10,9);
            }
        }

        for(int ind = 1; ind < n; ind++){
            for(int t = 0; t <= tar; t++){
                int notTake = 0 + dp[ind - 1][t];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (arr[ind] <= t)
                    take = 1 + dp[ind][t - arr[ind]];

                // Store the minimum result in the dp array
                dp[ind][t] = Math.min(notTake, take);
            }
        }

        int ans = dp[n-1][tar];
        return ans >= (int)Math.pow(10, 9) ? -1 : ans;

    }
}