class Solution {
    public boolean isThree(int n) {
        int sqrt = (int) Math.sqrt(n);
        
        // n must be a perfect square
        if (sqrt * sqrt != n) {
            return false;
        }

        // Check if sqrt is a prime number
        return isPrime(sqrt);
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
}