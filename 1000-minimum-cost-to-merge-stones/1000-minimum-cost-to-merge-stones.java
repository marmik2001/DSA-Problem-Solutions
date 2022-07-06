class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if(n==1)return 0;
        if((n-k)%(k-1)!=0)return -1;
        
        int[] prefix = new int[n+1];
        for (int i = 1; i<=n; i++)
            prefix[i] = prefix[i-1] + stones[i-1];

        
        int[][] dp = new int[n][n];
        for(int l=k;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j = i+l-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int mid = i; mid<j; mid+=k-1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }
                if ((j - i) % (k - 1) == 0)
                    dp[i][j] += prefix[j+1] - prefix[i];
            }
            
            
        }
        return dp[0][n-1];
    }
}