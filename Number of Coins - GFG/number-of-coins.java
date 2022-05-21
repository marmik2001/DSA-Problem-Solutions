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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{
	public int minCoins(int coins[], int M, int V) { 
	    int[] count = new int[V+1];
	    Arrays.fill(count,Integer.MAX_VALUE-1);
	    count[0] = 0;
	    for(int c:coins){
	        for(int j=c;j<=V;j++){
	            count[j] = Math.min(count[j-c]+1,count[j]);
	        }
	    }
	    return count[V]==Integer.MAX_VALUE-1?-1:count[V];
	} 
}