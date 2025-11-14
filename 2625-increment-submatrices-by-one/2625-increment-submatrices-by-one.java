class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matr = new int[n][n];

        /* Apply 2D difference updates for each rectangle:
           For query [rs, cs, re-1, ce-1], mark:
               (+1) at (rs, cs)                       : start of increment
               (-1) at (re, cs) if re < n             : stop vertical accumulation
               (-1) at (rs, ce) if ce < n             : stop horizontal accumulation
               (+1) at (re, ce) if both re, ce < n    : restore the overlap (inclusion–exclusion)
        */
        for (int[] q : queries) {
            int rs = q[0], cs = q[1];
            int re = q[2] + 1, ce = q[3] + 1;   // convert to exclusive bounds

            ++matr[rs][cs];           // start rectangle effect

            if (re < n) --matr[re][cs];      // stop vertical propagation
            if (ce < n) {
                --matr[rs][ce];              // stop horizontal propagation
                if (re < n) ++matr[re][ce];  // fix double-stop overlap
            }
        }

        /* Horizontal prefix sums: accumulate row-wise */
        for (int i = 0; i < n; ++i)
            for (int j = 1; j < n; ++j)
                matr[i][j] += matr[i][j - 1];

        /* Vertical prefix sums: accumulate column-wise */
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < n; ++j)
                matr[i][j] += matr[i - 1][j];

        return matr;
    }
}