class Solution {
    private int[][][] dp;
    private int[][] preprocess(String[] strs){
        int[][] x = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            for(char c:s.toCharArray()){
                if(c=='0')
                    x[i][0]++;
            }
            x[i][1] = s.length()-x[i][0];
        }
        return x;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = preprocess(strs);
        dp = new int[m+1][n+1][strs.length];
        for(int[][] x:dp){
            for(int[] y: x)
                Arrays.fill(y,-1);
        }
        return solve(arr,m,n,0);
    }
    private int solve(int[][] arr, int m, int n, int i){
        if(i==arr.length)return 0;
        if(dp[m][n][i]!=-1)return dp[m][n][i];
        int max = solve(arr,m,n,i+1);
        if(arr[i][0]<=m&&arr[i][1]<=n)max = Math.max(max, 1 + solve(arr,m-arr[i][0],n-arr[i][1],i+1));
        return dp[m][n][i] = max;
    }
}