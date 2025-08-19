class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long k = 0;

        for (var x : nums) {
            if (x == 0) {
                k++;
                ans += k;
            } else
                k = 0;
        }
        return ans;
    }
}