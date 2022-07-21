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
class BSTIterator {
    ArrayList<Integer> inorder;
    int i;
    public BSTIterator(TreeNode root) {
        i=0;
        inorder = new ArrayList<>();
        helper(root);
    }
    private void helper(TreeNode root){
        if(root==null)return;
        helper(root.left);
        inorder.add(root.val);
        helper(root.right);
    }
    
    public int next() {
        return inorder.get(i++);
    }
    
    public boolean hasNext() {
        return i<inorder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */