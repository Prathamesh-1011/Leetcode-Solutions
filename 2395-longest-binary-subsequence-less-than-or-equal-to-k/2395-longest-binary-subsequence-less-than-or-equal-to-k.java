class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        long value = 0;
        int power = 0;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '0') {
                // Always include zero since it doesn't change value
                count++;
                power++;
            } else {
                if (power < 32) { // Cap to prevent overflow
                    long add = 1L << power;
                    if (value + add <= k) {
                        value += add;
                        count++;
                    }
                }
                power++;
            }
        }

        return count;
    }
}