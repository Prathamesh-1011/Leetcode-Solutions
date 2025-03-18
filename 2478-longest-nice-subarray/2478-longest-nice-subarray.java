class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, currMask = 0, maxLen = 0;

        for (int r = 0; r < n; r++) {
            while ((currMask & nums[r]) != 0) {
                currMask ^= nums[l];
                l++;
            }

            currMask |= nums[r];
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}