// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private static long count;
    static long inversionCount(long arr[], long N){
        count = 0;
        long[] aux = new long[(int)N];
        helper(arr,aux,0,(int)N-1);
        return count;
    }
    private static void helper(long[] arr,long[] aux,int i,int j){
        if(i>=j)return;
        int mid = (i+j)/2;
        helper(arr,aux,i,mid);
        helper(arr,aux,(mid+1),j);
        merger(arr,aux,i,j,mid);
    }
    private static void merger(long[] arr,long[] aux,int lo,int hi,int mid){
        for(int k=lo;k<=hi;k++)
            aux[k] = arr[k];
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++) {
            if(i>mid)arr[k] = aux[j++];
            else if(j>hi)arr[k] = aux[i++];
            else if(aux[i]>aux[j]){
                count+=mid-i+1;
                arr[k] = aux[j++];
            }else arr[k] = aux[i++];
        }
    }
}