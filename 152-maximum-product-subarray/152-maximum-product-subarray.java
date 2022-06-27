class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for(int i=1, curMax = max, curMin = max;i<nums.length;i++){
            if(nums[i]<0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }        
            curMax = Math.max(curMax*nums[i],nums[i]);
            curMin = Math.min(curMin*nums[i],nums[i]);
            max = Math.max(max,curMax);
        }
        return max;
    }
}