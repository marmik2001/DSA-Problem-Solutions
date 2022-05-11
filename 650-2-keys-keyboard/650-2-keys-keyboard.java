class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i=1;i<=n/2;i++){
            for(int j=2;(i*j)<=n;j++){
                dp[i*j] = Math.min(dp[i*j],dp[i]+j);
            }
        }
        return dp[n];
    }
    
}