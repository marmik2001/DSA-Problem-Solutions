class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0], maxSum = nums[0], curMax = nums[0], minSum = nums[0],curMin=nums[0];
        for(int i=1;i<nums.length;i++){
            total+=nums[i];
            curMax = Math.max(nums[i],nums[i]+curMax);
            maxSum = Math.max(maxSum,curMax);
            curMin = Math.min(nums[i],nums[i]+curMin);
            minSum = Math.min(minSum,curMin);
        }
        return curMax>0?Math.max(maxSum,total-minSum):maxSum;
    }
}