class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
            Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode x = stack.peek();
            ans.add(x.val);
            while(x.left!=null){
                x = x.left;
                stack.add(x);
                ans.add(x.val);
            }
            while(!stack.isEmpty()&&stack.peek().right==null)
                stack.pop();
            if(!stack.isEmpty())
                stack.add(stack.pop().right);
        }
        return ans;
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