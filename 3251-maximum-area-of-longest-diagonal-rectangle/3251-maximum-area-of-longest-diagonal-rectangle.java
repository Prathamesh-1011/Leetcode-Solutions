class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
      int maxA=0,maxD=0;
      for(int[] d:dimensions)
      {
        int i=d[0];
        int j=d[1];
        if((i*i+j*j)>maxD)
        {
            maxA=i*j;
            maxD=i*i+j*j;
        }
        else if((i*i+j*j)==maxD)
        {
            maxA=Math.max(maxA,i*j);
        }
      }  
      return maxA;
    }
}