class Solution {
    private class Node{
        int val,index;
        Node next,prev;
        Node(){}
        Node(int val,int index){
            this.val = val;
            this.index = index;
        }
        Node(int val,int index,Node next,Node prev){
            this.val = val;
            this.index = index;
            this.next = next;
            this.prev = prev; 
        }
    }
    private Node head,tail;
    private void insert(Node x){
        while(head.prev!=tail&&head.prev.val<=x.val){
            head = head.prev;
            head.next = null;
        }
        x.next = head;
        x.prev = head.prev;
        head.prev.next = x;
        head.prev = x; 
    }
    private void initialize(){
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1)return nums;
        initialize();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<k;i++)
            insert(new Node(nums[i],i));
        ans[0] = tail.next.val;
        for(int i=k;i<nums.length;i++){
            insert(new Node(nums[i],i));
            while(tail.next.index<i-k+1){
                tail = tail.next;
                tail.prev = null;
            }
            ans[i-k+1] = tail.next.val;
        }
        return ans;
    }
}