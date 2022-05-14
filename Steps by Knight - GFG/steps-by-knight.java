// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n){
        int steps = 0;
        boolean[][] board = new boolean[n][n];
        TargetPos[0]--;
        TargetPos[1]--;
        Queue<Integer> X = new LinkedList<>();
        X.add(KnightPos[0]-1);
        Queue<Integer> Y = new LinkedList<>();
        Y.add(KnightPos[1]-1);
        board[KnightPos[0]-1][KnightPos[1]-1] = true;
        int curr = 1, next = 0;
        int[][] vec = new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        while(!X.isEmpty()){
            int x = X.poll();
            int y = Y.poll();
            if(x==TargetPos[0]&&y==TargetPos[1])return steps;
            for(int[] v:vec){
                int x1 = x+v[0];
                int y1 = y+v[1];
                if(x1>=0&&x1<n&&y1>=0&&y1<n&&!board[x1][y1]){
                    X.add(x1);
                    Y.add(y1);
                    next++;
                    board[x1][y1] = true;
                }
            }
            curr--;
            if(curr==0){
                steps++;
                curr = next;
                next=0;
            }
        }
        return -1;
    }
}