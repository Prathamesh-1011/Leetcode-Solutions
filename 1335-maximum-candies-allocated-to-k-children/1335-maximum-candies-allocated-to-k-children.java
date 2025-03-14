class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;
        
        for (int candy : candies) {
            right = Math.max(right, candy);
        }

        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canSatisfy(candies, k, mid)) {
                answer = mid; 
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }

        return answer;
    }

    private boolean canSatisfy(int[] candies, long k, int x) {
        long count = 0;
        
        for (int candy : candies) {
            count += candy / x;  
        }
        return count >= k;
    }
}