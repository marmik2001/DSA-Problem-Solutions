class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> revSol = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode x = stack.pop();
            revSol.add(x.val);
            if(x.left!=null)
                stack.add(x.left);
            if(x.right!=null)
                stack.add(x.right);
        }
        List<Integer> list = new ArrayList<>();
        while(!revSol.isEmpty())
            list.add(revSol.pop());
        return list;
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