class Solution {
    public int findNthDigit(int n) {
        int length = 1; 
        long count = 9;
        int start = 1;      
        
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        int number = start + (n - 1) / length;
        
        String numberStr = Integer.toString(number);
        int digitIndex = (n - 1) % length;
        
        return numberStr.charAt(digitIndex) - '0';
    }
}