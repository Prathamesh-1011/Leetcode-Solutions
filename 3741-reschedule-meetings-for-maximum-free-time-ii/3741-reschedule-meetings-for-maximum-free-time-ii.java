class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int max = 0;
        int n = startTime.length;
        max = 0;
        int res = 0;
        int prev = eventTime;
        int next = 0;
        for(int i = n - 1; i >= 0; i--){
            if(i > 0){
                next = endTime[i - 1];
            }else{
                next = 0;
            }
            res = Math.max(res, startTime[i] - next + prev - endTime[i]);
            if(endTime[i] - startTime[i] <= max){
                res = Math.max(res, prev - next);
            }
            
            max = Math.max(max, prev - endTime[i]);
            prev = startTime[i];
        }
        max = 0;
        prev = 0;
        for(int i = 0; i < n; i++){
            if(i < n - 1){
                next = startTime[i + 1];
            }else{
                next = eventTime;
            }
            res = Math.max(res, startTime[i] - prev + next - endTime[i]);
            if(endTime[i] - startTime[i] <= max){
                res = Math.max(res, next - prev);
            }
            max = Math.max(max, startTime[i] - prev);
            prev = endTime[i];
        }
        return res;
    }
}