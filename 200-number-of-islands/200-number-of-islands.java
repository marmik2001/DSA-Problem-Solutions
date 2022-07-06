class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]=='0')continue;
                count++;
                dfs(grid,m,n,r,c);
            }    
        }
        return count;
    }
    private void dfs(char[][] grid, int m, int n, int r, int c){
        if(r<0||r==m||c<0||c==n||grid[r][c]=='0')return;
        grid[r][c] = '0';
        dfs(grid,m,n,r-1,c);        
        dfs(grid,m,n,r+1,c);
        dfs(grid,m,n,r,c-1);
        dfs(grid,m,n,r,c+1);
    }
}