class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        int currentDay =0;
        int result = 0;
        int n = events.length;
        while(!pq.isEmpty() || index<n){
            if(pq.isEmpty()){
                currentDay = events[index][0];
            }
            while(index<n && events[index][0]<= currentDay){
                pq.offer(events[index][1]);
                index++;
            }
            pq.poll();
            result++;
            currentDay++;
            while(!pq.isEmpty() && pq.peek()<currentDay){
                pq.poll();
            }

        }
        return result;

    }
}