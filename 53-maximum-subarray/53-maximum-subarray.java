class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0],prev=0;
        for(int i:nums){
            prev = Math.max(i,prev+i);
            max = Math.max(max,prev);
        }
        return max;
    }
}