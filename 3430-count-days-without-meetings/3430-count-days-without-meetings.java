class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        long busyDays = 0;
        int n = meetings.length;
        
        int currStart = meetings[0][0];
        int currEnd = meetings[0][1];
        
        for (int i = 1; i < n; i++) {
            int nextStart = meetings[i][0];
            int nextEnd = meetings[i][1];
            
            if (nextStart <= currEnd + 1) {
                currEnd = Math.max(currEnd, nextEnd);
            } else {
                busyDays += (currEnd - currStart + 1);
                currStart = nextStart;
                currEnd = nextEnd;
            }
        }
        
        busyDays += (currEnd - currStart + 1);
        
        long freeDays = days - busyDays;
        
        return (int)freeDays;
    }
}