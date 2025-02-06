class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean cnt = false;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                cnt = true;
            }
        }
        return cnt;
    }
}