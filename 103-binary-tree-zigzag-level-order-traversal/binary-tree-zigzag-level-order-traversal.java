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
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        q.offer(root);
        boolean flag = false;

        while(!q.isEmpty()){
            List<Integer> t = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size; i++){
                TreeNode curr = q.poll();
                t.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            if(flag) Collections.reverse(t);
            res.add(t);
            flag = ! flag;
        }
        return res;
    }
}