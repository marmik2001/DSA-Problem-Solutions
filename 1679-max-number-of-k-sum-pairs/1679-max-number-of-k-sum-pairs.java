class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int key:map.keySet()){
            if(map.containsKey(k-key))
                count+=Math.min(map.get(key),map.get(k-key));
        }
        return count/2;
    }
}