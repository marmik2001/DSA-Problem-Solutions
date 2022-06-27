class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++)
            dp[i] = dp[i-1]+grid[0][i-1];
        
        for(int row=1;row<m;row++){
            dp[1] = grid[row][0]+dp[1];
            for(int col=2;col<=n;col++)
                dp[col] = grid[row][col-1]+Math.min(dp[col-1],dp[col]);
        }
        return dp[n];
    }
}