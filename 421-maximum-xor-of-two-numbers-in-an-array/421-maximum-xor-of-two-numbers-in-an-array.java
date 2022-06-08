class Solution {
    class Node{
        Node[] next = new Node[2];
    }
    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        Node root = new Node();
        for(int num:nums){
            Node x = root;
            for(int i=31;i>=0;i--){
                int bit = (num>>i)&1;
                if(x.next[bit]==null)
                    x.next[bit] = new Node();
                x = x.next[bit];
            }
        }
        for(int num:nums){
            Node x = root;
            int maxXor = 0;
            for(int i=31;i>=0;i--){
                int oppositeBit = ((num>>i)&1)^1;
                if(x.next[oppositeBit]!=null){
                    maxXor+=(1<<i);
                    x = x.next[oppositeBit];
                }else
                    x = x.next[oppositeBit^1];
            }
            max = Math.max(max,maxXor);
        }
        return max;
    }
}