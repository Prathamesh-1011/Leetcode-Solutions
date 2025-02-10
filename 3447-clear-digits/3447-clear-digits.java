class Solution {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int i = stack.length() - 1;
                while (i >= 0 && Character.isDigit(stack.charAt(i))) {
                    i--;
                }
                if (i >= 0) {
                    stack.deleteCharAt(i);
                }
            } else {
                stack.append(ch);
            }
        }   
        return stack.toString();
    }
}