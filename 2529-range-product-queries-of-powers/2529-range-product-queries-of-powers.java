class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        int pow = 1;
        while(n > 0) {
            if(n % 2 == 1)
                powers.add(pow);
            n /= 2;
            pow *= 2;
        }
        int m = powers.size();
        int[][] prefixProd = new int[m][m];
        for(int i = 0; i < m; i++) {
            long prod = 1;
            for(int j = i; j < m; j++) {
                prod = (prod * powers.get(j)) % MOD;
                prefixProd[i][j] = (int) prod;
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++)
            res[i] = prefixProd[queries[i][0]][queries[i][1]];
        return res;
    }
}