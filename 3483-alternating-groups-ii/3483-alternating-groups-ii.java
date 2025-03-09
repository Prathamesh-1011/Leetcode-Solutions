class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        int[] extended = new int[n + k - 1];
        for (int i = 0; i < n; i++) {
            extended[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            extended[n + i] = colors[i];
        }

        int[] alt = new int[extended.length];
        for (int i = 1; i < extended.length; i++) {
            alt[i] = (extended[i] != extended[i - 1]) ? 1 : 0;
        }

        int windowSum = 0;

        for (int i = 1; i < k; i++) {
            windowSum += alt[i];
        }

        for (int i = 0; i < n; i++) {
            if (windowSum == k - 1) {
                count++;
            }

            windowSum -= alt[i + 1];
            if (i + k < alt.length) {
                windowSum += alt[i + k];
            }
        }

        return count;
    }
}