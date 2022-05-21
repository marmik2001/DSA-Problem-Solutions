import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            if(prerequisite[0]==prerequisite[1])return false;
            List<Integer> x = adj.get(prerequisite[1]);
            x.add(prerequisite[0]);
        }
        HashMap<Integer,Integer> sort = new HashMap<>();
        int index = numCourses-1;
        boolean[] visited =new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
            index=dfs(adj,sort,i,visited,index);
        for(int[] x:prerequisites)
            if(sort.get(x[0])<sort.get(x[1]))return false;
        return true;
    }
    private int dfs(List<List<Integer>> adj,HashMap<Integer,Integer> sort,int index,boolean[] visited,int x){
        if(visited[index])return x;
        visited[index]=true;
        for(int i:adj.get(index)){
            x=dfs(adj,sort,i,visited,x);
        }
        sort.put(index,x);
        return x-1;
    }
}