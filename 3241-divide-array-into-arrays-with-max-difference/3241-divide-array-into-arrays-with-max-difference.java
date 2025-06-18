class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int len = nums.length;
        int[][] ans = new int[len/3][3];
        
        int r = -1, c = 0, first=0;
        
        int max = 0;
        for(int i : nums) {
            if(i>max) max = i;
        }     
         
        int freq[] = new int[max+1];
        for(int i : nums) {
            freq[i]++;
        }      
        
        
        for(int i=1; i<max+1;) {
            if(freq[i] == 0) i++;
            else{
                if(c == 0) {
                    r++;
                    first = i;
                }
                if((i-first) >k) return new int[0][0];
                ans[r][c] = i;
                c=(c+1)%3;
                freq[i]--;
                
            }
        }
        
        return ans;
    }
}