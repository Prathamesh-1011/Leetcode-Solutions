class Solution {
    static class Node {
        String name;
        TreeMap<String, Node> children = new TreeMap<>();
        String signature = "";
        Node(String name){
            this.name = name;
        }
    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");
        for (List<String> path : paths){
            Node node = root;
            for (String folder : path){
                node.children.putIfAbsent(folder, new Node(folder));
                node = node.children.get(folder);
            }
        }
        Map<String, Integer> count = new HashMap<>();
        DFS1(root, count);
        List<List<String>> res = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        DFS2(root, count, res, currPath);
        return res;
    }
    private String DFS1(Node node, Map<String, Integer> count){
        if (node.children.isEmpty()){
            node.signature = "";
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Node> entry : node.children.entrySet()){
            String name = entry.getKey();
            Node child = entry.getValue();
            String sig = DFS1(child, count);
            sb.append(name).append("(").append(sig).append(")");
        }
        node.signature = sb.toString();
        count.put(node.signature, count.getOrDefault(node.signature, 0) + 1);
        return node.signature;
    }
    private void DFS2(Node node, Map<String, Integer> count, List<List<String>> res, List<String> currPath){
        if (!node.signature.isEmpty() && count.get(node.signature) > 1){
            return;
        }
        if (!node.name.isEmpty()){
            currPath.add(node.name);
            res.add(new ArrayList<>(currPath));
        }
        for (Node child : node.children.values()){
            DFS2(child, count, res, currPath);
        }
        if (!node.name.isEmpty()){
            currPath.remove(currPath.size() - 1);
        }
    }
}