class Solution {
    public boolean isPalindrome(int x) {
       if (x < 0) {
            return false;
        }
        String strX = Integer.toString(x);
        int length = strX.length();
        for (int i = 0; i < length / 2; i++) {
            if (strX.charAt(i) != strX.charAt(length - 1 - i)) {
                return false;
            }
        }
        
        return true; 
    }
}