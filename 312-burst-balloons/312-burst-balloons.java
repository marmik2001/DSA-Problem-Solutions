class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        dp = new int[nums.length+1][nums.length+1];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return helper(nums,0,nums.length-1,1,1);
    }
    private int helper(int[] nums, int i, int j, int left, int right){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int x=i;x<=j;x++)
            max=Math.max(max,nums[x]*left*right+helper(nums,i,x-1,left,nums[x])+helper(nums,x+1,j,nums[x],right));
        return dp[i][j]=max;
    }
}