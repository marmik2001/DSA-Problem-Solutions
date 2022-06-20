// { Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}// } Driver Code Ends

class Solution {
    static int[] maxOfMin(int[] arr, int n) {
        int[] left = new int[n], right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]) stack.pop();
            if(!stack.isEmpty()) left[i] = stack.peek();
            else left[i] = -1;
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]) stack.pop();
            if(!stack.isEmpty()) right[i] = stack.peek();
            else right[i] = n;
            stack.push(i);
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int len = right[i] - left[i] - 1;
            ans[len-1] = Math.max(ans[len-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--)
            ans[i] = Math.max(ans[i],ans[i+1]);
        return ans;
    }
}