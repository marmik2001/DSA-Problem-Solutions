class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length, countFresh = 0;
        Queue<Integer> r = new LinkedList<>(), c = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    r.add(i);
                    c.add(j);
                }else if(grid[i][j]==1) countFresh++;
            }
        }
        int count = 0;
        int[][] vector = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        while(!r.isEmpty()&&countFresh>0){
            count++;
            int sz = r.size();
            while(sz-->0){
                int r1 = r.poll(), c1 = c.poll();
                for(int[] v:vector){
                    int r2 = r1+v[0];
                    int c2 = c1+v[1];
                    if(r2<0||r2==row||c2<0||c2==col||grid[r2][c2]!=1)continue;
                    grid[r2][c2] = 2;
                    r.add(r2);
                    c.add(c2);
                    countFresh--;
                }
            }
        }
        return countFresh==0?count:-1;
    }
}