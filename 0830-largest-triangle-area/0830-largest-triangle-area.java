class Solution
{
    public double largestTriangleArea(int[][] p)
    {
        double max = 0.0;
        
        for(int i=0, l=p.length; i<l-2; i++)
            for(int j=i+1, x1=p[i][0], y1=p[i][1]; j<l-1; j++)
                for(int k=0, x2=p[j][0], y2=p[j][1], q=(x1*y2)-(x2*y1), r=x2-x1, s=y1-y2; k<l; k++)
                    max = Math.max(max, Math.abs(q+(r*p[k][1])+s*p[k][0]));
        
        return max/2.0;
    }
}