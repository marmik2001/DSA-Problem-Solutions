class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i))continue;
            if(map.containsKey(i-1)){
                if(map.containsKey(i+1)){
                    map.put(i,map.get(i-1)+map.get(i+1)+1);
                    map.put(i-map.get(i-1),map.get(i));
                    map.put(i+map.get(i+1),map.get(i));
                }else{
                    map.put(i,map.get(i-1)+1);
                    map.put(i-map.get(i-1),map.get(i));
                }
            }else if(map.containsKey(i+1)){
                map.put(i,map.get(i+1)+1);
                map.put(i+map.get(i+1),map.get(i));
            }else
                map.put(i,1);
            max = Math.max(max,map.get(i));
        }
        return max;
    }
}