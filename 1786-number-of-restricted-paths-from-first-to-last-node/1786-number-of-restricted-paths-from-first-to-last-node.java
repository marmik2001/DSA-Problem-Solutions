class Solution {
    private Map<Integer, List<int[]>> map = new HashMap<>();
    private final static int mod = 1_000_000_007;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        for(int[] e : edges) {
            map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(new int[] { e[1], e[2] }); 
            map.computeIfAbsent(e[1], x -> new ArrayList<>()).add(new int[] { e[0], e[2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1])); 
        pq.add(new int[]{n,0});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[n] = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
			int weight = curr[1];
            for(int[] neighbor : map.get(node)) {
                int nei = neighbor[0];
                int w = weight + neighbor[1];
                if(w < dist[nei]) { 
                    dist[nei] = w;
                    pq.add(new int[]{ nei, w });
                }
            }
        }
        Integer[] dp = new Integer[n+1];
        return dfs(1, n, dist, dp);
    }
    public int dfs(int node, int end, int[] dist, Integer[] dp) {
        if(node == end) return 1;
        if(dp[node] != null) return dp[node];
        long res = 0;
        for(int[] neighbor : map.get(node)) {
            int nei = neighbor[0];
            if(dist[node] > dist[nei]) { 
                res = (res + (dfs(nei, end, dist, dp)) % mod);
            }
        }
        res = (res % mod);
        return dp[node] = (int) res;
    }
}