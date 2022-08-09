class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return helper(prices,fee,0,1);
    }
    private int helper(int[] prices, int fee, int i, int canBuy){
        if(i>=prices.length)return 0;
        if(dp[i][canBuy]!=-1)return dp[i][canBuy];
        if(canBuy==1)
            return dp[i][canBuy] = Math.max(-prices[i]+helper(prices,fee,i+1,0),helper(prices,fee,i+1,1));
        else
            return dp[i][canBuy] = Math.max(prices[i]-fee+helper(prices,fee,i+1,1),helper(prices,fee,i+1,0));
    }
}