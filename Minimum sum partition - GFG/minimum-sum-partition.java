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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution{
    private int min_diff,sum;
    boolean[][] dp;
    public int minDifference(int arr[], int n) { 
	    min_diff = Integer.MAX_VALUE;
	    sum = 0;
	    for(int i:arr)
	        sum+=i;
	    dp = new boolean[n][sum+1];
	    helper(arr,0,0);
	    return min_diff;
	} 
	private void helper(int[] arr,int s,int i){
	    if(i==arr.length){
	        min_diff = Math.min(min_diff,Math.abs(sum-2*s));
	        return;
	    }
	    if(dp[i][s])return;
	    dp[i][s] = true;
	    helper(arr,s+arr[i],i+1);
	    helper(arr,s,i+1);
	}
}
