class Solution {
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        helper(root,0,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,List<Integer>> tree:map.values()){
            List<Integer> list = new ArrayList<>();
            for(List<Integer> entry:tree.values()){
                Collections.sort(entry);
                list.addAll(entry);
            }
            ans.add(list);
        }
        return ans;
    }
    private void helper(TreeNode root, int h,int d) {
        if (root == null) return;
        if (map.containsKey(d)) {
            TreeMap<Integer,List<Integer>> m = map.get(d);
            if(m.containsKey(h)){
                m.get(h).add(root.val);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                m.put(h,list);
            }
        }
        else {
            TreeMap<Integer,List<Integer>> m = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            m.put(h,list);
            map.put(d, m);
        }
        helper(root.left, h + 1, d - 1);
        helper(root.right, h + 1, d + 1);
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