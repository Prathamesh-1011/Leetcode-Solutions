class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int count = 10, product = 9, availableDigits = 9;
        for (int i = 2; i <= n && availableDigits > 0; i++) {
            product *= availableDigits;
            availableDigits--;
            count += product;
        }
        return count;
    }
}