class Solution {
    private int[][] dp;
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        int n=0;
        arr[n++] = 1;
        for(int i:nums)
            if(i!=0)arr[n++] = i; 
        arr[n] = 1;
        dp = new int[n+1][n+1];
        return helper(arr,0,n,1,1);
    }
    private int helper(int[] nums, int i, int j, int left, int right){
        if(i+1==j)return 0;
        if(dp[i][j]!=0)return dp[i][j];
        int max = 0;
        for(int k=i+1;k<j;k++)
            max = Math.max(max,nums[k]*left*right+helper(nums,i,k,left,nums[k])+helper(nums,k,j,nums[k],right));
        return dp[i][j] = max;
    }
}