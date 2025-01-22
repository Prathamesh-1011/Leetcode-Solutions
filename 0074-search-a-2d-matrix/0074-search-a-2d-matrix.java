class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean num = false;
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == target){
                    num = true;
                }
            }
        }
        return num;
    }
}