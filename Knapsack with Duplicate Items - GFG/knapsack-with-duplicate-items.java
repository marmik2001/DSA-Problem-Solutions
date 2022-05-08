// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends

class Solution{
    static int[][] dp;
    static int knapSack(int N, int W, int[] val, int[] wt){
        dp = new int[N+1][W+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i],-1);
            dp[i][0] = 0;
        }

        return helper(N,W,val,wt);
    }
    static int helper(int N, int W, int[] val, int[] wt){
        if(dp[N][W]!=-1)return dp[N][W];
        if(wt[N-1]<=W) dp[N][W] = Math.max(val[N-1]+helper(N,W-wt[N-1],val,wt),helper(N-1,W,val,wt));
        else dp[N][W] = helper(N-1,W,val,wt);
        return dp[N][W];
    }
}