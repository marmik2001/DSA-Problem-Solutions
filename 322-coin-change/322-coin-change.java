class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        Set<Integer> x = new HashSet<>();
        for(int y:coins)
            x.add(y);
        Integer[] arr = x.toArray(new Integer[0]);
        for(int coin:arr){
            for(int j=coin;j<=amount;j++)
                dp[j] = Math.min(dp[j],1+dp[j-coin]);
        }
        return dp[amount]!=(Integer.MAX_VALUE-1)?dp[amount]:-1;
    }
}