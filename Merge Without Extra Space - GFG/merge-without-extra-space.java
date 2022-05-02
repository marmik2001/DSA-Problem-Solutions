// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends

class Solution{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i=0,j=0,k=0;
        long mx=Math.max(arr1[n-1],arr2[m-1])+1;
        while(i<n&&j<m){
            long x = arr1[i]%mx;
            long y = arr2[j]%mx;
            if(k<n){
                if(x<=y){
                    arr1[k++]+=mx*x;
                    i++;
                }
                else{
                    arr1[k++]+=mx*y;
                    j++;
                }
            }else{
                if(x<=y){
                    arr2[(k++)-n] = mx*x;
                    i++;
                }else{
                    arr2[(k++)-n] = mx*y;
                    j++;
                }
            }
        }
        while(i<n){
            long x = arr1[i++]%mx;
            if(k<n)
                arr1[k]+=x*mx;    
            else
                arr2[k-n]+=x*mx;
            k++;
        }
        while(j<m){
            long y = arr2[j++]%mx;
            arr2[k-n]+=y*mx;    
            k++;
        }
        for(i=0;i<n;i++)
            arr1[i]/=mx;
        for(j=0;j<m;j++)
            arr2[j]/=mx;  
    }
}
