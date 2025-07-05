class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int result = -1;
        
        // Check for lucky numbers
        for (int num : freq.keySet()) {
            if (num == freq.get(num)) {
                result = Math.max(result, num);
            }
        }

        return result;
    }
}