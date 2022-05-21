class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0,n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i]&&dp[i]<dp[j]+1)
                    dp[i] = dp[j]+1;
        }
        for(int i:dp)
            max = Math.max(max,i);
        return max;
    }
}