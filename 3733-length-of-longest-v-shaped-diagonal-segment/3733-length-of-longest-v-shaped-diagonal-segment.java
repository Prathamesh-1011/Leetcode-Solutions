class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    int[] result = new int[4];
                    for(int k=0; k<4; k++) {
                        result[k] = check(i, j, r, c, grid, k);
                        max = Math.max(max, result[k]+1);
                    }
                }
            }
        }
        return max;
    }

    public int populate(int i, int j, int r, int c, int[][] grid, int dir) {
        int rend = r;
        int cend = c;
        int rinc = 1;
        int cinc = 1;
        switch(dir) {
            case 0:
                rend = -1;
                cend = -1;
                rinc = -1;
                cinc = -1;
                break;
            case 1:
                rend = -1;
                cend = c;
                rinc = -1;
                cinc = 1;
                break;
            case 3:
                rend = r;
                cend = -1;
                rinc = 1;
                cinc = -1;
                break;
        }
        int len = 0;
        int prev = grid[i][j];
        i += rinc;
        j += cinc;
        while(i != rend && j != cend && grid[i][j] == 2-prev) {
            len++;
            prev = grid[i][j];
            i += rinc;
            j += cinc;
        }
        return len;
    }

    public int check(int i, int j, int r, int c, int[][] grid, int dir) {
        int rend = r;
        int cend = c;
        int rinc = 1;
        int cinc = 1;
        switch(dir) {
            case 0:
                rend = -1;
                cend = -1;
                rinc = -1;
                cinc = -1;
                break;
            case 1:
                rend = -1;
                cend = c;
                rinc = -1;
                cinc = 1;
                break;
            case 3:
                rend = r;
                cend = -1;
                rinc = 1;
                cinc = -1;
                break;
        }
        int len = 0;
        int prev = grid[i][j];
        i += rinc;
        j += cinc;
        if(i == rend || j == cend || grid[i][j] != 2) {
            return 0;
        }
        int max = 0;
        while(i != rend && j != cend && grid[i][j] != prev && grid[i][j] != 1) {
            len++;
            prev = grid[i][j];
            max = Math.max(max, len + populate(i, j, r, c, grid, (dir+1)%4));
            i += rinc;
            j += cinc;
        }
        return max;
    }
}