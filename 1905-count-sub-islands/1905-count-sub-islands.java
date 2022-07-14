class Solution {
    private int[] v = new int[]{0,1,0,-1,0};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length, count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==0)continue;
                ArrayList<int[]> island = new ArrayList<>();
                dfs(grid2,island,m,n,i,j);
                boolean flag = true;
                for(int[] x:island){
                    if(grid1[x[0]][x[1]]==0){
                        flag = false;
                        break;
                    }
                }
                if(flag)count++;
            }
        }
        return count;
    }
    private void dfs(int[][] grid, ArrayList<int[]> island,int m, int n, int r, int c){
        island.add(new int[]{r,c});
        grid[r][c]=0;
        for(int i=0;i<4;i++){
            int r1 = r+v[i];
            int c1 = c+v[i+1];
            if(r1<0||r1==m||c1<0||c1==n||grid[r1][c1]==0)
                continue;
            dfs(grid,island,m,n,r1,c1);
        }
    }
}