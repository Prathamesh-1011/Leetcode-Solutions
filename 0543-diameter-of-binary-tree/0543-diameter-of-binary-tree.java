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
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);
        int currDiameter = maxDepthLeft + maxDepthRight;
        diameter = Math.max(diameter, currDiameter);
        return 1 + Math.max(maxDepthLeft, maxDepthRight);
    }
}