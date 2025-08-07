class Solution {
    int yesRec(int r, int i, List<List<Integer>> triangle, Integer[][] dp) {
        if (i > r)
            return Integer.MAX_VALUE;
        
        if (r == triangle.size() - 1)
            return triangle.get(r).get(i);
        
        if (dp[r][i] != null)
            return dp[r][i];
        
        int down1 = yesRec(r + 1, i, triangle, dp);
        int down2 = yesRec(r + 1, i + 1, triangle, dp);

        return dp[r][i] = Math.min(down1, down2) + triangle.get(r).get(i);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return yesRec(0, 0, triangle, dp);
    }
}