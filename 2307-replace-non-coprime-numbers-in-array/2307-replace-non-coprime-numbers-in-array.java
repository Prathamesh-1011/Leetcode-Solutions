import java.util.*;

class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        // Use long multiplication to prevent overflow
        return (int)((long) a * b / gcd(a, b));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            while (!result.isEmpty()) {
                int last = result.get(result.size() - 1);
                int currentGcd = gcd(last, num);

                if (currentGcd == 1) {
                    break;  // Coprime → keep both numbers
                }

                // Merge non-coprime pair safely using long
                num = lcm(last, num);
                result.remove(result.size() - 1);  // Remove last since merged
            }

            result.add(num);
        }

        return result;
    }
}