class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveA = getDayOfYear(arriveAlice);
        int leaveA = getDayOfYear(leaveAlice);
        int arriveB = getDayOfYear(arriveBob);
        int leaveB = getDayOfYear(leaveBob);

        int overlapStart = Math.max(arriveA, arriveB);
        int overlapEnd = Math.min(leaveA, leaveB);

        if (overlapStart > overlapEnd) {
            return 0;
        }
        return overlapEnd - overlapStart + 1;
    }

    private int getDayOfYear(String date) {
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;

        return dayOfYear;
    }
}