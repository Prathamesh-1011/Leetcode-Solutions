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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null)
        return res;

        q.add(root);
        boolean flag = true;

        while(!q.isEmpty()){
            List<Integer> sub = new ArrayList<>();
            int l = q.size();

            for(int i=0;i<l;i++){
                TreeNode tn = q.poll();

                sub.add(tn.val);

                if(tn.left != null)
                q.add(tn.left);
                if(tn.right != null)
                q.add(tn.right);

                //sub.add(q.remove().data);
            }

            if(!flag){
                 Collections.reverse(sub);
            }
            res.add(sub);
            flag = !flag;

        }
        return res;
    }
}