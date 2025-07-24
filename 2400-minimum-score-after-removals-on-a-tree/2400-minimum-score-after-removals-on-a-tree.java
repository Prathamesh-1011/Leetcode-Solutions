class Solution {
    private List<Integer>[] tree;
    private int[] nums;
    private int[] xor;
    private int[] in, out;
    private int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        xor = new int[n];
        in = new int[n];
        out = new int[n];
        tree = new List[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        dfs(0, -1); // fill xor,in, out
        int totalXor = xor[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) { // first cut
            for (int j = 1; j < n; j++) { // second cut
                if (i == j)
                    continue;
                if (isAncestor(i, j)) {
                    int a = xor[j];
                    int b = xor[i] ^ xor[j];
                    int c = totalXor ^ xor[i];
                    res = Math.min(res, getScore(a, b, c));
                } else if (isAncestor(j, i)) {
                    int a = xor[i];
                    int b = xor[j] ^ xor[i];
                    int c = totalXor ^ xor[j];
                    res = Math.min(res, getScore(a, b, c));
                } else {
                    int a = xor[i];
                    int b = xor[j];
                    int c = totalXor ^ xor[i] ^ xor[j];
                    res = Math.min(res, getScore(a, b, c));
                }
            }
        }
        return res;
    }

    private void dfs(int node, int parent) {
        xor[node] = nums[node];
        in[node] = time++;
        for (int child : tree[node]) {
            if (child == parent)
                continue;
            dfs(child, node);
            xor[node] ^= xor[child];
        }
        out[node] = time++;
    }

    private boolean isAncestor(int u, int v) {
        return in[u] < in[v] && out[v] < out[u];
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}