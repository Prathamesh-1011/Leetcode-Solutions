class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0, n = s.length();
        
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            total = total * 10 + digit;
            index++;
        }
        
        return total * sign;
    }
}
