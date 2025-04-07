class Solution 
{
    public int maximalSquare(char[][] matrix) 
    {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];   
        int result = 0;     
        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                if(matrix[i - 1][j - 1] == '0')
                {
                    dp[i][j] = 0;
                }
                else
                {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
dp[i][j] = min + 1;
                    dp[i][j] = min + 1;
                }
                result = result < dp[i][j] ? dp[i][j] : result ;
            }
        }
        return result * result;
    }
}