// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private int dp[];
    int findMaxSum(int arr[], int n) {
        dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,n,0);
    }
    int helper(int[] arr,int n,int i){
        if(i>=n)
            return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i] = Math.max(arr[i]+helper(arr,n,i+2),helper(arr,n,i+1));
    }
}