class Solution {
    public int numberOfPairs(int[][] points) {
        // Sorting the array and if the 1st coordinate is same then we will sort them according to 2nd coordinate in descending order
        Arrays.sort(points, (a,b) -> a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]);

        int result = 0;
        for(int i = 0; i < points.length; i++) {
            // For point A - Upper Point
            int x1 = points[i][0], y1 = points[i][1];
            int bottom = Integer.MIN_VALUE;
            for(int j = i + 1; j < points.length; j++) {
                // Find B - Find Lower Right points
                int x2 = points[j][0], y2 = points[j][1];
                if(bottom < y2 && y2 <= y1) {
                    // found a valid rectangle
                    result++;
                    bottom = y2;
                    // to avoid points on the same value of y
                    if(y2 == y1) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}