class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<List<Integer>> conflict = new ArrayList<>();
        for (int i = 0; i <= n ; i++){
            conflict.add(new ArrayList<>());
        }
        for (int[] pair : conflictingPairs){
            int u = pair[0], v = pair[1];
            conflict.get(Math.max(u, v)).add(Math.min(u, v));
        }
        long res = 0;
        int maxDiff = 0, maxLeft = 0;
        long[] prefix = new long[n + 1]; 
        for (int r = 1; r <= n; r++){
            for (int l : conflict.get(r)) {
                if (l > maxDiff){
                    int temp = maxDiff;
                    maxDiff = l;
                    maxLeft = temp;
                } else if (l > maxLeft){
                    maxLeft = l;
                }
            }
            res += r - maxDiff;
            if (maxDiff > 0){
                prefix[maxDiff] += (long)(maxDiff - maxLeft);
            }
        }
        long maxBonus = 0;
        for (long val : prefix){
            maxBonus = Math.max(maxBonus, val);
        }
        return res + maxBonus;
    }
}