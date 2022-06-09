// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}
// } Driver Code Ends

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(arr2.length<arr1.length)return kthElement(arr2,arr1,m,n,k);
        int lo = 0;
        int hi = Math.min(k,n);
        while(lo<=hi){
            int cut1 = (lo+hi)/2;
            int cut2 = k - cut1;
            if(cut2>m){
                lo = cut1+1;
                continue;
            }
            int left1 = cut1!=0?arr1[cut1-1]:Integer.MIN_VALUE;
            int left2 = cut2!=0?arr2[cut2-1]:Integer.MIN_VALUE;
            int right1 = cut1!=n?arr1[cut1]:Integer.MAX_VALUE;
            int right2 = cut2!=m?arr2[cut2]:Integer.MAX_VALUE;
            if(left1<=right2&&left2<=right1)
                return Math.max(left1,left2);
            else if(left1>right2)
                hi = cut1-1;
            else
                lo = cut1+1;
        }
        return -1;
    }
}