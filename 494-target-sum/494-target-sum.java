class Solution {
    private int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i:nums)
            sum+=i;
        if(target>sum)return 0;
        if((sum-target)%2!=0)return 0;
        int goal = (sum-target)/2;
        dp = new int[nums.length][goal+1];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return helper(nums,goal,0);        
    }
    private int helper(int[] nums,int target,int i){
        if(i==nums.length){
            if(target==0)return 1;
            return 0;
        }
        if(target<0)return 0;
        if(dp[i][target]!=-1)return dp[i][target]; 
        return dp[i][target] = helper(nums,target-nums[i],i+1)+helper(nums,target,i+1);
    }
}