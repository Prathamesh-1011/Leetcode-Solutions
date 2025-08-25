class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        // initialize res array
        int len = m * n;
        int[] res = new int[len];
        res[0] = mat[0][0];

        // initialize pointers
        int i = 0, j = 0, k = 1;

        while (k < len) {
            // move diag top-right
            while (isValid(i - 1, j + 1, m, n) && k < len) {
                res[k] = mat[i - 1][j + 1];
                i--; j++;
                k++;
            }

            // move right or move down only once
            if (isValid(i, j + 1, m, n) && k < len) {
                res[k] = mat[i][j + 1];
                j++; k++;
            } else if (k < len) {
                res[k] = mat[i + 1][j];
                i++; k++;
            }

            // move diag left-down
            while (isValid(i + 1, j - 1, m, n) && k < len) {
                res[k] = mat[i + 1][j - 1];
                i++; j--;
                k++;
            }

            // move down or move right only once
            if (isValid(i + 1, j, m, n) && k < len) {
                res[k] = mat[i + 1][j];
                i++; k++;
            } else if (k < len) {
                res[k] = mat[i][j + 1];
                j++; k++;
            }
        }

        return res;
    }

    public boolean isValid(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }
}