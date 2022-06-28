class Solution {
    private int m,n,mod = 1000000007;
    private int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        dp = new int[m][n][maxMove];
        for(int[][] x:dp)
            for(int[] y:x)
                Arrays.fill(y,-1);
        return helper(startRow,startColumn,maxMove);
    }

    private int helper(int row, int col, int maxMove){
        if(row==m||col==n||row==-1||col==-1)return 1;
        if(maxMove==0)return 0;
        if(dp[row][col][maxMove-1]!=-1)return dp[row][col][maxMove-1];
        int moves = 0;
        moves = (moves+helper(row+1,col,maxMove-1))%mod;
        moves = (moves+helper(row,col+1,maxMove-1))%mod;
        moves = (moves+helper(row-1,col,maxMove-1))%mod;
        moves = (moves+helper(row,col-1,maxMove-1))%mod;
        return dp[row][col][maxMove-1] = moves;
    }
}