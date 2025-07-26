import java.util.*;

public class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int maxNeg = Integer.MIN_VALUE;
        int total = 0;
        boolean hasPositive = false;

        for (int num : nums) {
            maxNeg = Math.max(maxNeg, num);

            if (num >= 0 && !seen.contains(num)) {
                seen.add(num);
                total += num;
                hasPositive = true;
            }
        }

        return hasPositive ? total : maxNeg;
    }
}