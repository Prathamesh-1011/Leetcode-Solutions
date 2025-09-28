class Solution {
    public int compareVersion(String v1, String v2) {
        int i = 0, j = 0;

        while (i < v1.length() && j < v2.length()) {
            int num1 = 0, num2 = 0;

            while (i < v1.length() && v1.charAt(i) != '.') {
                num1 = num1 * 10 + v1.charAt(i) - '0';
                i++;
            }
            while (j < v2.length() && v2.charAt(j) != '.') {
                num2 = num2 * 10 + v2.charAt(j) - '0';
                j++;
            }

            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;
            i++;
            j++;
        }

        if (i < v1.length() && valuePresent(i, v1))
            return 1;
        else if (valuePresent(j, v2))
            return -1;
        return 0;
    }

    boolean valuePresent(int i, String s) {
        for (; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '.')
                return true;
        }

        return false;
    }
}