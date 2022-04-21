class Solution {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, max = 0;
        //i<nums.length coupled with return (jumps-1) doesn't work
        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max,i+nums[i]);
            if(i==end){
                jumps++;
                end = max;
            }
        }
        return jumps;
    }
}