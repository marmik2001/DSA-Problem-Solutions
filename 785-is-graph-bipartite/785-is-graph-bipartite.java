class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(color[i]!=0)continue;
            color[i] = 1;
            queue.add(i);
            while(!queue.isEmpty()){
                int x = queue.poll();
                for(int y:graph[x]){
                    if(color[y]==0){
                        if(color[x]==1)
                            color[y] = 2;
                        else color[y] = 1;
                        queue.add(y);
                    }
                    else if(color[y]==color[x])return false;
                }
            }
        }
        return true;
    }
}