class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] vector = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int[][] dist = new int[m][n];
        for(int[] x:dist)
            Arrays.fill(x,Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(x[2]>dist[x[0]][x[1]])continue;
            if(x[0]==m-1&&x[1]==n-1)return x[2];
            for(int[] v:vector){
                int r = x[0]+v[0];
                int c = x[1]+v[1];
                if(r<0||r==m||c<0||c==n||dist[r][c]<=Math.max(x[2],Math.abs(heights[x[0]][x[1]]-heights[r][c])))continue;
                dist[r][c] = Math.max(x[2],Math.abs(heights[x[0]][x[1]]-heights[r][c]));
                pq.add(new int[]{r,c,dist[r][c]});
            }
        }
        return -1;
    }
}