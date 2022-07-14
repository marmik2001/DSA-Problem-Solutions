class Solution {
    private boolean flag;
    private int[] v = new int[]{0,1,0,-1,0};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==0)continue;
                flag = true;
                dfs(grid1,grid2,m,n,i,j);
                if(flag) count++;
            }
        }
        return count;
    }
    private void dfs(int[][] grid1,int[][] grid2,int m, int n, int r, int c){
        if(grid1[r][c]==0)flag = false;
        grid2[r][c]=0;
        for(int i=0;i<4;i++){
            int r1 = r+v[i];
            int c1 = c+v[i+1];
            if(r1<0||r1==m||c1<0||c1==n||grid2[r1][c1]==0)
                continue;
            dfs(grid1,grid2,m,n,r1,c1);
        }
    }
}