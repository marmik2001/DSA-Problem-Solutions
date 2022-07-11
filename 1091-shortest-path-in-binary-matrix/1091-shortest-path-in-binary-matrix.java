class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0)return -1;
        int n = grid.length;
        int[][] vector = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[2]);
        grid[0][0] = 1;
        int cur = 1, next = 0, steps = 1;
        while(!queue.isEmpty()){
            int[] x = queue.poll();
            if(x[0]==n-1&&x[1]==n-1)return steps;
            cur--;
            for(int[] v:vector){
                int r = x[0]+v[0];
                int c = x[1]+v[1];
                if(r<0||r==n||c<0||c==n||grid[r][c]!=0)continue;
                grid[r][c] = 1;
                queue.add(new int[]{r,c});
                next++;
            }
            if(cur==0){
                cur = next;
                next = 0;
                steps++;
            }
        }
        return -1;
    }
}