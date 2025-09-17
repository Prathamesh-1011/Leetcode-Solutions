/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; // start from last index in postorder
        inorderIndexMap = new HashMap<>();

        // Map value -> index in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        // No elements to construct subtree
        if (left > right) return null;

        // Get current root from postorder
        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Build right subtree first (because in postorder we go [Left, Right, Root])
        root.right = arrayToTree(postorder, inorderIndexMap.get(rootValue) + 1, right);
        root.left = arrayToTree(postorder, left, inorderIndexMap.get(rootValue) - 1);

        return root;
    }
}