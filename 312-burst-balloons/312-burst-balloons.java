class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0] = 1;
        arr[nums.length+1] = 1;
        for(int i=1;i<=nums.length;i++)
            arr[i] = nums[i-1];
        dp = new int[nums.length+1][nums.length+1];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return helper(arr,1,nums.length);
    }
    private int helper(int[] nums, int i, int j){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int x=i;x<=j;x++)
            max=Math.max(max,nums[x]*nums[i-1]*nums[j+1]+helper(nums,i,x-1)+helper(nums,x+1,j));
        return dp[i][j]=max;
    }
}