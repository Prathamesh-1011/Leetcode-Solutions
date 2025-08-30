class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int u = n-2;
        int b = n-1;
        int[][] res = grid;
        ArrayList<ArrayList<Integer>> bl = new ArrayList<>();
        for(int r=0;r<n-1;r++){
            ArrayList<Integer> bsl = new ArrayList<>();
            int c =0;
            for(int i=n-r;i>=1;i--){
                bsl.add(grid[r+c][c]);
                c++;
            }
            sortlist(bsl);
            c=0;
              for(int i=n-r;i>=1;i--){
                res[r+c][c] = bsl.get(bsl.size()-1-c);
                c++;
            }
        }
        for(int c=1;c<n-1;c++){
            ArrayList<Integer> bsl = new ArrayList<>();
            int r =0;
            for(int i=n-c;i>=1;i--){
                bsl.add(grid[r][c+r]);
                r++;
            }
            sortlist(bsl);
            r=0;
              for(int i=n-c;i>=1;i--){
                res[r][c+r] = bsl.get(r);
                r++;
            }
        }
        return res;
    }
    public void sortlist(ArrayList<Integer> l){
        int[] a = new int[l.size()];
        for(int i=0;i<l.size();i++){
            a[i] = l.get(i);
        }
        Arrays.sort(a);
        for(int i=0;i<l.size();i++){
            l.set(i,a[i]);
        }
    }
}