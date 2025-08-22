class Solution {
    public int minimumArea(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int minh=0;
        outerLoop:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
             if(grid[i][j]==1){
                minh=i;
                break outerLoop;
             }
            }
        }

        int maxh=0;
        outerLoop:
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
             if(grid[i][j]==1){
                maxh=i;
                break outerLoop;
             }
            }
        }

        int height=(maxh-minh)+1;

        int minw=0;
        outerLoop:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
             if(grid[j][i]==1){
                minw=i;
                break outerLoop;
             }
            }
        }

        int maxw=0;
        outerLoop:
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
             if(grid[j][i]==1){
                maxw=i;
                break outerLoop;
             }
            }
        }

        int width= (maxw-minw)+1;

    return height * width;
    }
}