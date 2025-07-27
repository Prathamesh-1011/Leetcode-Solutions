class Solution {
    public int countHillValley(int[] nums) {
        int h=0;
        int v=0;
        int n=nums.length;
        int newlen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[newlen - 1]) {
                nums[newlen] = nums[i];
                newlen++;
            }
        }
        for(int i=1;i<newlen-1;i++){
            if(nums[i]> nums[i-1] && nums[i]>nums[i+1]){
                h++;
            }
            else if(nums[i]<nums[i-1]&& nums[i]<nums[i+1]){
                v++;
            }
        }
        return h+v;
    }
}