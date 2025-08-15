class Solution {
    public int minInsertions(String s) {
        return longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s,t);
    }

    public int lcs(String s, String t){
        int m = s.length();
        int n = t.length();

        int dp[][] = new int[m+1][n+1];

        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= n; i++){
            dp[0][i] = 0;
        }
        for (int ind1 = 1; ind1 <= m; ind1++) {
            for (int ind2 = 1; ind2 <= n; ind2++) {
                if (s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[m][n];
    }
}