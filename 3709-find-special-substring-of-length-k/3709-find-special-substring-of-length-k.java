class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count == k) {
                boolean leftCheck = (i - k >= 0) ? s.charAt(i - k) != s.charAt(i) : true;
                boolean rightCheck = (i + 1 < n) ? s.charAt(i + 1) != s.charAt(i) : true;

                if (leftCheck && rightCheck) {
                    return true;
                }
            }
        }
        return false;
    }
}