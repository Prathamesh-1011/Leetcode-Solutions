class Solution {
    public int singleNumber(int[] nums) {
        int firstPass = 0, secondPass = 0;
        for (int current : nums) {
            firstPass = (firstPass ^ current) & ~secondPass;
            secondPass = (secondPass ^ current) & ~firstPass;
        }
        return firstPass;
    }
}