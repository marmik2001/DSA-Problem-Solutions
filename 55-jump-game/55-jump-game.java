class Solution {
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)return true;
        int i=1,j = nums[0];
        for(;j>=i&&i<n&&j<n;i++)
            j = Math.max(j,i+nums[i]);
        if(j>=n-1)return true;
        return false;
    }
    
}