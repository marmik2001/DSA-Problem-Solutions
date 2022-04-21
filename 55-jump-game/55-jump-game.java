class Solution {
    
    public boolean canJump(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(j<i)return false;
            if(j>=nums.length-1)return true;
            j = Math.max(j,nums[i]+i);
        }
        return true;
    }
    
}