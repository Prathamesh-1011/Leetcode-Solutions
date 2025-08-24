class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, zero = 0, maxlen = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zero++;

            // shrink window until it has at most one zero
            while (zero > 1) {
                if (nums[l] == 0) zero--;
                l++;
            }

            // effective length = window size - 1 (since one deletion is mandatory)
            maxlen = Math.max(maxlen, r - l);
        }
        return maxlen;
    }
}