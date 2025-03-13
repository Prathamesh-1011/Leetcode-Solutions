class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0; 
        int right = queries.length;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canZero(nums, queries, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long[] diff = new long[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r + 1 < n) {
                diff[r + 1] -= val;
            }
        }

        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            if (curr < nums[i]) {
                return false;
            }
        }

        return true;
    }
}