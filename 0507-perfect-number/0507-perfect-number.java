class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false; 

        int sum = 1;
        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                int correspondingDivisor = num / i;
                if (i != correspondingDivisor) {
                    sum += correspondingDivisor;
                }
            }
        }

        return sum == num;
    }
}