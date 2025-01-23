class Solution {
    public void sortColors(int[] nums) {
        for (int turn = 1; turn < nums.length; turn++) {
            for (int i = 0; i < nums.length - turn; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}