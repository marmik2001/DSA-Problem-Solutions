// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends

class Sol{
    private static Set<String> set;
    private static class Node{
        boolean word=false;
        Node[] next = new Node[26];
    }
    private static Node root;
    private static void insert(String s){
        Node x = root;
        for(char c:s.toCharArray()){
            int index = c-97;
            if(x.next[index]==null)
                x.next[index] = new Node();
            x = x.next[index];
        }
        x.word = true;
    }
    public static int wordBreak(String A, ArrayList<String> B ){
        root = new Node();
        set = new HashSet<>();
        for(String s:B)
            insert(s);
        return check(A)?1:0;
    }
    private static boolean check(String s){
        if(s.equals(""))return true;
        if(set.contains(s))return false;
        set.add(s);
        Node x = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);  
            int index = c-97;
            if(x.next[index]==null)return false;
            x = x.next[index];
            if(x.word&&check(s.substring(i+1)))
                return true;
        }
        return false;
    }
}







