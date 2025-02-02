class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;    
        
        return (int) (power(5, evenCount) * power(4, oddCount) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}