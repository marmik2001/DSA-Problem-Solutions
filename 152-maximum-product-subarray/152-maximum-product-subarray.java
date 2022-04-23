class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], curMax = nums[0], curMin = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                max = Math.max(max,0);
                curMax = 1;
                curMin = 1;
                continue;
            }
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