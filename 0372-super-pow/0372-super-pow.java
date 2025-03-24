class Solution {
    private final int MOD = 1337;
    public int superPow(int a, int[] b) {
        return helper(a, b);
    }

    private int helper(int a, int[] b) {
        int res = 1;

        for (int i = b.length-1; i >= 0; i--) {
            res = (int) (res * pow(a, b[i])) % MOD;
            a = (int) pow(a, 10);
        }
        return res;
    }

    private int pow(int a, int b) {
        int res = 1;
        a %= MOD;
        for (int i = 0; i < b; i++) {
            res = (res * a) % MOD;
        }
        return res;
    }
}