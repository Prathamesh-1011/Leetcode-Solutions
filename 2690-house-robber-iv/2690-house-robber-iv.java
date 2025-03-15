class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canRob(int[] nums, int k, int cap) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; ) {
            if (nums[i] <= cap) {
                count++;
                i += 2; 
            } else {
                i += 1;
            }
        }
        
        return count >= k;
    }
}