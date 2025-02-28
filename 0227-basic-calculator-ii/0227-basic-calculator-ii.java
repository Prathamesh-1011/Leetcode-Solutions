class Solution {
    public int calculate(String s) {
        int num = 0, result = 0, lastNum = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (operation == '+') {
                    result += lastNum;
                    lastNum = num;
                } else if (operation == '-') {
                    result += lastNum;
                    lastNum = -num;
                } else if (operation == '*') {
                    lastNum *= num;
                } else if (operation == '/') {
                    lastNum /= num;
                }

                operation = c;
                num = 0;
            }
        }

        return result + lastNum;
    }
}
