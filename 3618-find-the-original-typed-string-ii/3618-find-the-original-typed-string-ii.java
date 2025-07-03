class Solution {
    public int possibleStringCount(String word, int k) {
        
        long res = 1;
        int MOD = 1000000007;
        List<Integer> list = new ArrayList<>();
        int r = 0;
        int n = word.length();
        while (r < n) {
            int count = 1;
            while (r + 1 < n && word.charAt(r) == word.charAt(r + 1)) {
                r++;
                count++;
            }
            list.add(count);
            res = (res * count + MOD) % MOD;
            r++;
        }

        if (list.size() >= k) {
            return (int)res;
        }
        int off = k - list.size() - 1;
        int[] f = new int[off + 1];
        Arrays.fill(f, 1);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                continue;
            }
            int cur = list.get(i) - 1;
            int[] f2 = new int[off + 1];
            int[] pre = new int[off + 2];
            for (int i1 = 0; i1 <= off; i1++) {
                pre[i1 + 1] = (pre[i1] + f[i1]) % MOD;
            }
            int possible = Math.min(cur, off);
            for (int x = 0; x <= off; x++) {
                int target = Math.min(x + possible + 1, off + 1);
                f2[x] = (pre[target] - pre[x] + MOD) % MOD;
            }
            
            f = f2;
            
        }
        return (int)(res - f[0] + MOD) % MOD;
    }

}