class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> gaps = new ArrayList<>();
        int n = startTime.length;

        // Pehle ka gap
        gaps.add(startTime[0] - 0);

        // Beech ke gaps
        for (int i = 0; i < n - 1; i++) {
            gaps.add(startTime[i + 1] - endTime[i]);
        }

        // Last meeting ke baad ka gap
        gaps.add(eventTime - endTime[n - 1]);

        int maxFree = 0, sum = 0;
        int len = gaps.size();

        for (int i = 0; i < Math.min(k + 1, len); i++) {
            sum += gaps.get(i);
        }
        maxFree = Math.max(maxFree, sum);

        if (k + 1 > len) return maxFree;

        // Sliding window
        for (int i = k + 1; i < len; i++) {
            sum += gaps.get(i) - gaps.get(i - (k + 1));
            maxFree = Math.max(maxFree, sum);
        }

        return maxFree;
    }
}