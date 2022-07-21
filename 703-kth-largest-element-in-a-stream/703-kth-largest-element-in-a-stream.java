class KthLargest {
    int k;
    PriorityQueue<Integer> min; 
    public KthLargest(int k, int[] nums) {
        this.k = k;
        min = new PriorityQueue<>();
        for(int i=0;i<k&&i<nums.length;i++)
            min.add(nums[i]);
        for(int i=k;i<nums.length;i++){
            if(nums[i]>min.peek()){
                min.poll();
                min.add(nums[i]);
            }
        }
    }
    public int add(int val) {
        if(min.size()<k)
            min.add(val);
        else if(val>min.peek()){
            min.poll();
            min.add(val);
        }
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */