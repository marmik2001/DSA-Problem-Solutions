class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][2];
        for(int[][] x:dp)
            for(int[] y:x)
                Arrays.fill(y,-1);
        return helper(prices,0,2,1);
    }
    private int helper(int[] prices, int i, int k, int canBuy){
        if(k==0)return 0;
        if(i==prices.length)return 0;
        if(dp[i][k-1][canBuy]!=-1)return dp[i][k-1][canBuy]; 
        if(canBuy==1)
            return dp[i][k-1][canBuy] = Math.max(-prices[i]+helper(prices,i+1,k,0),helper(prices,i+1,k,canBuy));
        else
            return dp[i][k-1][canBuy] = Math.max(prices[i]+helper(prices,i+1,k-1,1),helper(prices,i+1,k,canBuy));
    }
}