class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i:nums)            
            map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o->-map.get(o)));
        for(int i:map.keySet())            
            pq.add(i);
        int[] ans = new int[k];
        for(int i=0;i<k;i++)
            ans[i] = pq.poll();
        return ans;
    }
}