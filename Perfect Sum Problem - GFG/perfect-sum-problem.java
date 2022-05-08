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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    int[][] dp;
    private int MOD = 1000000007;
	public int perfectSum(int arr[],int n, int sum) { 
	    dp = new int[n][sum+1];
	    for(int[] x:dp)
	        Arrays.fill(x,-1);
	    return helper(arr,sum,0);
	} 
	private int helper(int[] nums,int target,int i){
        if(i==nums.length)
            return target==0?1:0;
        if(target<0)return 0;
        if(dp[i][target]!=-1)return dp[i][target];
        return dp[i][target] = (helper(nums,target-nums[i],i+1)+helper(nums,target,i+1))%MOD;
    }
}