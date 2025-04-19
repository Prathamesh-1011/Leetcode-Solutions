class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        
        for (String dir : path.split("/")) {
            if (dir.isEmpty() || dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(dir);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}