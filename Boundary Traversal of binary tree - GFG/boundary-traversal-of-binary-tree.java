// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution{
	ArrayList<Integer> leaves;

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        Node x = root.left;
        while (x != null) {
            if (isLeaf(x)) break;
            ans.add(x.data);
            if (x.left != null) x = x.left;
            else x = x.right;
        }
        Stack<Integer> stack = new Stack<>();
        x = root.right;
        while (x != null) {
            if (isLeaf(x)) break;
            stack.add(x.data);
            if (x.right != null) x = x.right;
            else x = x.left;
        }
        leaves = new ArrayList<>();
        if(!isLeaf(root))
            leaves(root);
        ans.addAll(leaves);
        while (!stack.isEmpty())
            ans.add(stack.pop());
        return ans;
    }

    private void leaves(Node root) {
        if (root == null) return;
        if (isLeaf(root)) {
            leaves.add(root.data);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

    private boolean isLeaf(Node node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }
}
