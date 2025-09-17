class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: postfix products
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * postfix;
            postfix *= nums[i];
        }

        return answer;
    }
}
