class Solution {
    private static class Node{
        int dest;
        long time;
        Node(int dest, long time){
            this.dest = dest;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] road : roads) {
            adj.get(road[0]).add(new Node(road[1], road[2]));
            adj.get(road[1]).add(new Node(road[0], road[2]));
        }
        //{time, index}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o->o[0]));
        pq.add(new long[2]);
        long[] time = new long[n];
        int[] numWays = new int[n];
        Arrays.fill(time, -1);
        time[0] = 0;
        numWays[0] = 1;
        while(!pq.isEmpty()){
            long[] city = pq.poll();
            if(city[0]>time[(int)city[1]])continue;
            if(city[1]==n-1)return numWays[(int)city[1]];
            for(Node x:adj.get((int)city[1])){
                long newCost = city[0]+x.time;
                if(time[x.dest]==-1||newCost<time[x.dest]){
                    time[x.dest] = newCost;
                    numWays[x.dest] = numWays[(int)city[1]];
                    pq.add(new long[]{newCost,x.dest});
                }else if(newCost==time[x.dest])
                    numWays[x.dest] = (numWays[x.dest]+numWays[(int)city[1]])%1000000007;
            }
        }
        return -1;
    }
}





