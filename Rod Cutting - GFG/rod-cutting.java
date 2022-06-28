// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    int max;
    int[][] dp;
    public int cutRod(int price[], int n) {
        max = Integer.MIN_VALUE;
        dp = new int[n][n+1];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return helper(price,0,n);
    }
    private int helper(int[] arr, int index, int n){
        if(index==arr.length||n==0)
            return 0;
        if(dp[index][n]!=-1)return dp[index][n];
        int max = arr[n-1];
        for(int count=0;n>=count*(index+1);count++)
            max = Math.max(max,arr[index]*count+helper(arr,index+1,n-count*(index+1)));
        return dp[index][n] = max;
    }
    
    
}