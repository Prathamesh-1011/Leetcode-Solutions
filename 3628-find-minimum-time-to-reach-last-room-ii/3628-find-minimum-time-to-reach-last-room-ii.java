class Solution {
   int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
    
   public int minTimeToReach(int[][] moveTime) {
        int m=moveTime.length, n=moveTime[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.add(new int[]{0,0,0,0});
        boolean[][] visited = new boolean[m][n];
        long[][][] d = new long[m][n][2];
        for(int i = 0;i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(d[i][j], Long.MAX_VALUE);
            }
        }


        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int x=cur[0], y=cur[1], time=cur[2], moveType=cur[3];
            if (visited[x][y]) continue;
            visited[x][y]=true;
            
            if(x==m-1 && y==n-1) {
                return time;
            }

            for(int[] dir: dirs){
                int nextX=x+dir[0], nextY=y+dir[1];
                if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY]){
                    int nextTime=time + (moveType==0? 1: 2);
                    nextTime = Math.max(nextTime, moveTime[nextX][nextY] + (moveType==0? 1: 2));

                    int nextType=1-moveType;
                    if(nextTime<d[nextX][nextY][nextType]){
                        d[nextX][nextY][nextType] = nextTime;
                        queue.offer(new int[]{nextX, nextY, nextTime, nextType});
                    }
                }
            }
        }

        return -1;
    }
}