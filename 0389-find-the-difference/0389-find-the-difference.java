class Solution {
    public char findTheDifference(String s, String t) {
        char miss = 0; 
        int len = t.length();

        for(int i = 0; i < len; i++) {  
            if(i < s.length()) {  
                miss ^= s.charAt(i);  
            }
            miss ^= t.charAt(i); 
        }
        return miss;
    }
}