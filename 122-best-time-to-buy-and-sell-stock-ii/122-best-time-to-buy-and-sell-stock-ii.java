class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length-1;i++){
            if(prices[i]<buy)
                buy=prices[i];
            else{
                if(prices[i+1]<prices[i]){
                    profit+=prices[i]-buy;
                    buy = prices[i];
                }
            }
        }
        profit+=Math.max(0,prices[prices.length-1]-buy);
        return profit;
    }
}