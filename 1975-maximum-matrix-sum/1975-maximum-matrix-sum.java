class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count=0;
        long sum=0;
        int min=10000000;
        for(int i = 0 ; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j]<0) count++;
                sum+=Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
         if(count%2==0)return sum;
         return sum-(2*min);

        
    }
}