class Solution {
    public int jump(int[] nums) {
        // If there's only one element, we are already at the end, so 0 jumps needed.
        if (nums.length == 1) {
            return 0;
        }

        int jumps = 0; // Stores the minimum number of jumps
        int currentJumpEnd = 0; // Marks the end of the current jump's reach
        int farthest = 0; // Tracks the farthest index reachable so far

        // Iterate through the array up to the second-to-last element.
        // We don't need to process the last element itself because
        // we are trying to reach it, not jump from it.
        for (int i = 0; i < nums.length - 1; i++) {
            // Update 'farthest' to the maximum reach from any position encountered so far
            // within the current jump.
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range (currentJumpEnd),
            // it means we must make a jump to extend our reach.
            if (i == currentJumpEnd) {
                jumps++; // Increment the jump count
                currentJumpEnd = farthest; // Set the new end of our jump to the farthest point we could reach
            }

            // If the farthest point we can reach is already beyond or at the last index,
            // we can stop early as we've found a path.
            if (currentJumpEnd >= nums.length - 1) {
                break;
            }
        }
        return jumps;
    }
}