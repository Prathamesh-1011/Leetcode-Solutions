class Solution {
    public int[] constructDistancedSequence(int n) {
        int length = 2 * n - 1;
        int[] result = new int[length];
        boolean[] used = new boolean[n + 1];
        Arrays.fill(result, 0);
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) {
            return true;
        }

        if (result[index] != 0) {
            return backtrack(result, used, index + 1, n);
        }

        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;

            if (i == 1) {
                result[index] = 1;
                used[i] = true;
                if (backtrack(result, used, index + 1, n)) {
                    return true;
                }
                result[index] = 0;
                used[i] = false;
            } else {
                int secondIndex = index + i;
                if (secondIndex < result.length && result[secondIndex] == 0) {
                    result[index] = result[secondIndex] = i;
                    used[i] = true;
                    if (backtrack(result, used, index + 1, n)) {
                        return true;
                    }
                    result[index] = result[secondIndex] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}