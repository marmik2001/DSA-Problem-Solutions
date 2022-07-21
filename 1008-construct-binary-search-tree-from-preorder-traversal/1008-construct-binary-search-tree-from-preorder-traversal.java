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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] nextLargerIndex = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&preorder[stack.peek()]<preorder[i])
                stack.pop();
            if(stack.isEmpty())
                nextLargerIndex[i] = n;
            else
                nextLargerIndex[i] = stack.peek();
            stack.add(i);
        }
        return helper(preorder,nextLargerIndex,0,n-1);
    }
    private TreeNode helper(int[] preorder, int[] nextLargerIndex, int i, int j){
        if(j<i)return null;
        TreeNode x = new TreeNode(preorder[i]);
        if(i==j)return x;
        x.left = helper(preorder, nextLargerIndex, i+1, nextLargerIndex[i]-1);
        x.right = helper(preorder, nextLargerIndex, nextLargerIndex[i], j);
        return x;
    }
}