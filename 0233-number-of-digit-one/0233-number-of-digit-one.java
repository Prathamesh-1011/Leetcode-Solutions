class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1;
        
        while (factor <= n) {
            long lower = n - (n / factor) * factor;
            long curr = (n / factor) % 10;
            long higher = n / (factor * 10);
            
            if (curr == 0) {
                count += higher * factor;
            } else if (curr == 1) {
                count += higher * factor + lower + 1;
            } else {
                count += (higher + 1) * factor;
            }
            
            factor *= 10;
        }
        
        return count;
    }
}