class Solution { 
    List<Integer> sol;
    public List<Integer> inorderTraversal(TreeNode root) {
        sol = new ArrayList<>();
        helper(root);
        return sol;
    }
    private void helper(TreeNode root){
        if(root==null)return;
        helper(root.left);
        sol.add(root.val);
        helper(root.right);
    }
}
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