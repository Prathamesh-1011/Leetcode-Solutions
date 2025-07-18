class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> numb = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numb.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < numb.size(); j++) {
                if (nums1[i] == 0) {
                    nums1[i] = numb.get(j);
                    numb.remove(j);
                }
            }
        }
        Arrays.sort(nums1);
    }
}