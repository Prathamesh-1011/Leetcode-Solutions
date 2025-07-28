class Solution {
    private int maxOR = 0, totalSubsets = 0;

    public void findSubsets(int[] nums, int idx, int tempTotal) {
        if (idx < nums.length) {
            findSubsets(nums, idx + 1, tempTotal);
            findSubsets(nums, idx + 1, tempTotal | nums[idx]);
        } else {
            if (tempTotal == maxOR) totalSubsets++;
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) maxOR |= num;
        findSubsets(nums, 0, 0);
        return totalSubsets;
    }
}