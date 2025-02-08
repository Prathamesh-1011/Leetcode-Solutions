// class Solution {
//     public int uniquePaths(int m, int n) {
//         return countPaths(0, 0, m ,n);
//     }

//     public int countPaths(int i, int j, int m, int n) {
//        if(i == m-1 || j == n-1) {
//            return 1;
//        }


//        return countPaths(i+1, j, m, n) + countPaths(i, j+1, m, n);
//     }
// }
class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        int k = Math.min(m - 1, n - 1);
        for (int i = 0; i < k; i++) {
            res = res * (m + n - 2 - i) / (i + 1);
        }
        return (int) res;
    }
}
