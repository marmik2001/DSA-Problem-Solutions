// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i:S)
            set.add(i);
        Integer[] coins = set.toArray(new Integer[0]);
        long[] arr = new long[n+1];
        arr[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=n;j++){
                if(arr[j-coins[i]]>0)
                    arr[j]+=arr[j-coins[i]];
            }
        }
        return arr[n];
    }
}