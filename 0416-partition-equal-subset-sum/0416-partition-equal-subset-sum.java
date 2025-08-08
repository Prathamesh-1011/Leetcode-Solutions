class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        } else {
            int k = sum / 2;
            int dp[][] = new int[n][k+1];
            for(int row[] : dp){
                Arrays.fill(row,-1);
            }
            return sub(n-1,k,nums,dp);
        }
    }
    public boolean sub(int ind, int k, int[] nums, int[][] dp){
        if(k == 0){
            return true;
        }

        if(ind == 0){
            return nums[0] == k;
        }

        if (dp[ind][k] != -1)
            return dp[ind][k] == 0 ? false : true;

        boolean nottake = sub(ind-1,k,nums,dp);
        boolean take = false;
        if(nums[ind] <= k){
            take = sub(ind-1,k-nums[ind],nums,dp);
        }

        dp[ind][k] = nottake || take ? 1 : 0;
        return nottake || take;
    }
}