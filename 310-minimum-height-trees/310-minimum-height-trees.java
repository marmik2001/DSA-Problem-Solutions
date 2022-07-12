class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            indegree[a]++;
            indegree[b]++;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1)
                queue.add(i);
        }
        while(n>2){
            int size = queue.size();
            n-=size;
            while((size--)>0){
                int node = queue.poll();
                for(int x:adj.get(node)){
                    indegree[x]--;
                    if(indegree[x]==1)
                        queue.add(x);
                }
            }
        }
        res.addAll(queue);
        return res;
    }
}