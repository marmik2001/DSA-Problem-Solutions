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

class Solution{
	public int minDifference(int arr[], int n) { 
	   int sum = 0;
	   for(int i:arr)
	       sum+=i;
	   int target = sum/2;
	   boolean[] canGet = new boolean[target+1];
	   canGet[0] = true;
	   for(int i=0;i<n;i++){
	       boolean[] bool = new boolean[target+1];
	       for(int j=0;j<target;j++){
	           if(canGet[j]){
	               if(j+arr[i]<=target)
	                   bool[j+arr[i]] = true;
	           }
	       }
	       for(int j=0;j<=target;j++)
	            canGet[j] = canGet[j]||bool[j];
	   } 
	   for(int i=target;i>=0;i--)
	        if(canGet[i])return Math.abs(sum-2*i);
	        
	   return -1;
	} 
}
