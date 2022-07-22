/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode x = queue.poll();
            if(x==null){
                str.append("# ");
                continue;
            }
            str.append(x.val+" ");
            queue.add(x.left);
            queue.add(x.right);
        }
        return str.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        TreeNode[] nodes = new TreeNode[arr.length];
        if(arr[0].equals("#"))return null;
        nodes[0] = new TreeNode(Integer.parseInt(arr[0]));
        int i=0, j=1;
        while(j<arr.length){
            if(arr[i].equals("#")){
                i++;
                continue;
            }
            TreeNode x = nodes[i];
            nodes[i] = x;
            i++;
            if(!arr[j].equals("#")){
                nodes[j] = new TreeNode(Integer.parseInt(arr[j]));
                x.left = nodes[j];    
            }
            j++;
            if(!arr[j].equals("#")){
                nodes[j] = new TreeNode(Integer.parseInt(arr[j]));
                x.right = nodes[j];
            }
            j++;       
        }
        return nodes[0];
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));