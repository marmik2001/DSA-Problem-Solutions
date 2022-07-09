// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends

class Solution{
    private static int[] root, sz;
    private static void initialize(int V){
        root = new int[V];
        sz = new int[V];
        for(int i=0;i<V;i++){
            root[i] = i;
            sz[i] = 1;
        }
    }
    private static int root(int a){
        while(a!=root[a]){
            root[a] = root[root[a]];
            a = root[a];
        }
        return a;
    }
    private static boolean isConnected(int a, int b){
        int x = root(a);
        int y = root(b);
        return x==y;
    }
    private static void union(int a, int b){
        int x = root(a);
        int y = root(b);
        if(x==y)return;
        if(sz[x]<sz[y]){
            sz[x]+=sz[y];
            root[x] = y;
        }else{
            sz[y]+=sz[x];
            root[y] = x;
        }
    }
    private static class Edge{
        int a, b, dist;
        Edge(int a, int b, int dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int sum = 0;
        initialize(V);
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(ArrayList<Integer> edge: adj.get(i)){
                edges.add(new Edge(i,edge.get(0),edge.get(1)));
            }
        }
        Collections.sort(edges, Comparator.comparingInt(o->o.dist));
        for(Edge x: edges){
            if(isConnected(x.a,x.b))continue;
            sum+=x.dist;
            union(x.a,x.b);
        }
        return sum;
    }
    
}
