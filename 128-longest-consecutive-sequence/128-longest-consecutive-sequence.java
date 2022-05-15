class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums)
            set.add(i);
        for(int i:nums){
            if(!set.contains(i-1)){
                int local = i;
                while(set.contains(local))
                    local++;
                ans = Math.max(ans,local-i);
            }
        }
        return ans;
    }
}