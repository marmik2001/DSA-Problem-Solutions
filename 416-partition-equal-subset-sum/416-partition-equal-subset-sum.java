class Solution {
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums)
            sum+=i;
        if(sum%2!=0)return false;
        dp = new boolean[nums.length][sum/2+1];
        return helper(sum/2,nums,0);
    }
    private boolean helper(int target,int[] nums,int i){
        if(target==0)return true;
        if(i==nums.length)return false;
        if(dp[i][target])return false;
        dp[i][target] = true;
        if(nums[i]<=target)
            return helper(target-nums[i],nums,i+1)||helper(target,nums,i+1);
        else return helper(target,nums,i+1);
    }
}