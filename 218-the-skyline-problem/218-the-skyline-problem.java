class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> solution = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for(int[] b:buildings){
            heights.add(new int[]{b[0],b[2]});
            heights.add(new int[]{b[1],-b[2]});
        }
        Collections.sort(heights, (o1,o2) -> (o1[0]-o2[0]!=0?o1[0]-o2[0]:o2[1]-o1[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prev=0;
        for(int[] h:heights){
            if(h[1]<0)
                pq.remove(-h[1]);
            else
                pq.add(h[1]);
            if(pq.peek()!=prev){
                ArrayList<Integer> x = new ArrayList<>();
                x.add(h[0]);
                x.add(pq.peek());
                solution.add(x);
                prev = pq.peek();
            }
        }
        return solution;
    }
}