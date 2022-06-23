class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1 = path(root,p.val);
        ArrayList<TreeNode> p2 = path(root,q.val);
        int limit = Math.min(p1.size(),p2.size())-1;
        for(int i=0;i<limit;i++){
            if(p1.get(i+1)!=p2.get(i+1))
                return p1.get(i);
        }
        return p1.get(limit);
    }
    public ArrayList<TreeNode> path(TreeNode A, int B) {
        ArrayList<TreeNode> sol = new ArrayList<>();
        found(A,B,sol);
        return sol;
    }
    private boolean found(TreeNode root, int B, ArrayList<TreeNode> sol){
        if(root==null)return false;
        if(root.val==B){
            sol.add(root);
            return true;
        }
        sol.add(root);
        if(found(root.left,B,sol))return true;
        if(found(root.right,B,sol))return true;
        sol.remove(sol.size()-1);
        return false;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
