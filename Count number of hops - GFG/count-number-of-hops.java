// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of steps in stair
            int n = sc.nextInt();
            
            //calling method countWays() of class Hops
            System.out.println(new Solution().countWays(n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n){
        if (n==1)return 1;
        if(n==2) return 2;
        int a=1,b=2,c=4,mod = 1000000007;
        n-=3;
        while(n>0){
            int temp = ((a+b)%mod+c)%mod;
            a = b;
            b = c;
            c = temp;
            n--;
        }
        return c;
    }
    
}

