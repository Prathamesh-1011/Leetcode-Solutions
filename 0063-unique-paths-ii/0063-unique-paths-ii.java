class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start or end is an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return UniquePath(0, 0, m, n, dp, obstacleGrid);
    }

    public int UniquePath(int i, int j, int m, int n, int[][] dp, int[][] obstacleGrid) {
        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // If current cell is obstacle
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        // If reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = UniquePath(i + 1, j, m, n, dp, obstacleGrid);
        int right = UniquePath(i, j + 1, m, n, dp, obstacleGrid);
        dp[i][j] = down + right;
        return dp[i][j];
    }
}