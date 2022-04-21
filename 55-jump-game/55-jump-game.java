class Solution {
    
    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        int i=1,j = nums[0];
        for(;j>=i&&i<nums.length;i++)
            j = Math.max(j,i+nums[i]);
        if(i==nums.length)return true;
        return false;
    }
    
}