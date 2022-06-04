// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends

class Solution {
    static ArrayList<String> sol;
    static int[][] vectors = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[] dir = new char[]{'U', 'R', 'D', 'L'};

    public static ArrayList<String> findPath(int[][] m, int n) {
        sol = new ArrayList<>();
        if (m[0][0] == 0) return sol;
        helper(m, n, new boolean[n][n], 0, 0, new StringBuilder());
        return sol;
    }

    private static void helper(int[][] m, int n, boolean[][] visited, int row, int col, StringBuilder str) {
        if (row == n - 1 && col == n - 1) {
            sol.add(new String(str.toString()));
            return;
        }
        visited[row][col] = true;
        for(int i=0;i<4;i++) {
            int r1 = row+vectors[i][0], c1 = col+vectors[i][1];
            if(r1<0||r1>=n||c1<0||c1>=n||visited[r1][c1]||m[r1][c1]==0)continue;
            str.append(dir[i]);
            helper(m,n,visited,r1,c1,str);
            str.deleteCharAt(str.length()-1);
        }
        visited[row][col] = false;
    }
}