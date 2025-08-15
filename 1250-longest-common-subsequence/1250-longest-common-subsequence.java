class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m][n];

        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return lcs(text1,text2,m-1,n-1,dp);
    }

    public int lcs(String s1, String s2, int ind1, int ind2, int dp[][]){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + lcs(s1,s2,ind1-1,ind2-1,dp);
        }

        return dp[ind1][ind2] = Math.max(lcs(s1, s2, ind1, ind2 - 1, dp),lcs(s1, s2, ind1 - 1, ind2, dp));
    }
}