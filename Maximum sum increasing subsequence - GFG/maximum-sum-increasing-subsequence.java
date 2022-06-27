// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends

class Solution{
    int[][] dp;
	public int maxSumIS(int arr[], int n)  { 
	    dp = new int[n][n+1];
	    for(int[] x:dp)
	        Arrays.fill(x,-1);
	    return solve(arr,0,-1);
	}  
	private int solve(int[] arr, int i, int prev){
	    if(i==arr.length)return 0;
	    if(dp[i][prev+1]!=-1)return dp[i][prev+1];
	    if(prev!=-1&&arr[i]<=arr[prev])return dp[i][prev+1] = solve(arr,i+1,prev);
	    return dp[i][prev+1] = Math.max(arr[i]+solve(arr,i+1,i),solve(arr,i+1,prev));
	}
}