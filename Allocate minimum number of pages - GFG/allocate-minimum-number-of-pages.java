// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends

class Solution {
    //Function to find minimum number of pages.
    public static int findPages(int[] A,int N,int M){
        int lo = Integer.MAX_VALUE, hi=0, res=-1;
        for(int i:A){
            lo = Math.min(lo,i);
            hi+=i;
        }
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(possible(A,M,mid)){
                res = mid;
                hi = mid-1;
            }else
                lo = mid+1;
        }
        return res;
    }
    private static boolean possible(int[] arr,int m,int pageLimit){
        int count = 1, lSum = 0;
        for(int i:arr){
            if(i>pageLimit)return false;
            if(i+lSum>pageLimit){
                count++;
                lSum = i;
            }else
                lSum+=i;
        }
        return count<=m;
    }
}





