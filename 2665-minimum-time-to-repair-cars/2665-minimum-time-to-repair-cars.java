class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) (1L * getMinRank(ranks) * cars * cars);
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (canRepair(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int getMinRank(int[] ranks) {
        int min = ranks[0];
        for (int r : ranks) {
            if (r < min) min = r;
        }
        return min;
    }
    
    private boolean canRepair(int[] ranks, int cars, long time) {
        long totalCars = 0;
        
        for (int r : ranks) {
            long n = (long) Math.sqrt(time / r);
            totalCars += n;
            
            if (totalCars >= cars) return true;
        }
        
        return totalCars >= cars;
    }
}