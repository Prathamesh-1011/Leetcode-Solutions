class Solution {
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            int rem = n - i;
            if (2 * limit < rem) {
                continue;
            }
            int y = rem - Math.min(limit, rem);
            ans = ans + (Math.min(rem, limit) - y + 1);
        }
        return ans;
    }
}