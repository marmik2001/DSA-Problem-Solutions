class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res =  new ArrayList<>();
        dfs(graph, new ArrayList<>(),graph.length,0);
        return res;
    }
    private void dfs(int[][] graph,List<Integer> arr,int n, int i){
        arr.add(i);
        if(i==n-1){
            List<Integer> local = new ArrayList<>();
            local.addAll(arr);
            res.add(local);
        }
        for(int x:graph[i])
            dfs(graph,arr,n,x);
        arr.remove(arr.size()-1);
    }
}