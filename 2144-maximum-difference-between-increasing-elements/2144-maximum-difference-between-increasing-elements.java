class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];  // Store the minimum value seen so far
        int res = -1;       // Result variable initialized to -1 as per problem statement
        int i = 0;

        // Iterate through the array until the second last element
        while (i < nums.length - 1) {
            // Update the minimum value encountered so far
            min = Math.min(min, nums[i]);

            // Check if the next element can give a valid positive difference
            if (nums[i + 1] - min > 0 && res < nums[i + 1] - min) {
                res = nums[i + 1] - min;  // Update result with max difference
            }

            i++;  // Move to the next index
        }

        return res;  // Return the maximum positive difference or -1 if not found
    }
}