class Solution {
    private long getHash(int num) {
        long hash = 1;
        long[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

        while (num > 0) {
            int digit = num % 10;
            hash *= primes[digit]; 
            num /= 10;
        }
        return hash;
    }

    public boolean reorderedPowerOf2(int n) {
        long target = getHash(n);

        for (int i = 0; i < 31; i++) { 
            if (getHash(1 << i) == target) {
                return true;
            }
        }
        return false;
    }
}