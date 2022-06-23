class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if(root==null)return sol;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(;size>0;size--){
                TreeNode x = queue.poll();
                list.add(x.val);
                if(x.left!=null)queue.add(x.left);
                if(x.right!=null)queue.add(x.right);
            }
            sol.add(list);
        }
        for(int i=1;i<sol.size();i+=2)
            Collections.reverse(sol.get(i));
        return sol;
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