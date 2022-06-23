
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int max = 0;
        queue.add(root);
        map.put(root,1);
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0;
            int end = 0;
            for(int i=0;i<size;i++){
                TreeNode x = queue.poll();
                int n = map.get(x);
                if(i==0)start = n;
                if(i==size-1)end = n;
                if(x.left!=null){
                    queue.add(x.left);
                    map.put(x.left,2*n);
                }
                if(x.right!=null){
                    queue.add(x.right);
                    map.put(x.right,2*n+1);
                }
            }
            max = Math.max(max,end-start+1);
        }
        return max;
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