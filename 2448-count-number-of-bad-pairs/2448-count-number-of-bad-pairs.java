class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;

        Map<Integer, Long> countMap = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            goodPairs += countMap.getOrDefault(diff, 0L);
            countMap.put(diff, countMap.getOrDefault(diff, 0L) + 1);
        }

        return totalPairs - goodPairs;
    }
}