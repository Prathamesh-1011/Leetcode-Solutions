class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        prefix[0] = -1;
        for(int i = 1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1],nums[i-1]);
        }
        suffix[n-1] = -1;
        for(int i = n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],nums[i+1]);
        }
        long res = 0;
        for(int i = 1;i<n-1;i++){
            res = Math.max(res,(prefix[i]-nums[i])*suffix[i]);
        }
        return res;
    }
}