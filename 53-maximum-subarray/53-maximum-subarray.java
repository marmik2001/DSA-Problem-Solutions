class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0],prev=nums[0];
        for(int i=1;i<nums.length;i++){
            prev = Math.max(nums[i],prev+nums[i]);
            max = Math.max(max,prev);
        }
        return max;
    }
}