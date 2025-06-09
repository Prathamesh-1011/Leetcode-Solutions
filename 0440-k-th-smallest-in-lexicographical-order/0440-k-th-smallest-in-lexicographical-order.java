class Solution {
    public int findKthNumber(int n, int k) {
        int[] K = new int[]{k};
        return dfs(0, n, K);
    }
    private int dfs(int prefix, int n, int[] K) {
        if (prefix != 0) {
            K[0]--;
            if (K[0] == 0) {
                return prefix;
            }
        }
        int startDigit = (prefix == 0 ? 1 : 0);
        for (int d = startDigit; d <= 9; d++) {
            int next = prefix * 10 + d;
            if (next > n) break;

            long cnt = countPrefix(n, next);
            if (cnt < K[0]) {
                K[0] -= cnt;
            } else {
                return dfs(next, n, K);
            }
        }
        return -1;
    }

    private long countPrefix(int n, long prefix) {
        long cnt    = 0;
        long first  = prefix;
        long second = prefix + 1;

        while (first <= n) {
            cnt += Math.min(n + 1L, second) - first;
            first  *= 10;
            second *= 10;
        }
        return cnt;
    }
}