// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends

class Solution{
    private static HashMap<String,Integer> map;
    private static HashMap<String,Boolean> isPalindrome;
    static int palindromicPartition(String str){
        map = new HashMap<>();
        isPalindrome = new HashMap<>();
        return helper(str);
    }
    static int helper(String S){
        if(S.length()<2||isPalindrome(S))return 0;
        if(map.containsKey(S))return map.get(S);
        char c = S.charAt(0);
        int min = 1+helper(S.substring(1));
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)!=c)continue;
            if(isPalindrome(S.substring(0,i+1)))
                min = Math.min(min,1+helper(S.substring(i+1)));
        }
        map.put(S,min);
        return min;
    }
    private static boolean isPalindrome(String s){
        if(isPalindrome.containsKey(s))return isPalindrome.get(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                isPalindrome.put(s,false);
                return false;
            }
        }
        isPalindrome.put(s,true);
        return true;
    }
}