class Solution {
    List<List<Integer>> solution;
    HashMap<Integer,Integer> map;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        solution = new ArrayList<>();
        Arrays.sort(nums);
        map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        helper(nums,0,new ArrayList<>());
        return solution;
    }
    private void helper(int[] nums, int i, List<Integer> x){
        if(i==nums.length){
            solution.add(x);
            return;
        }
        List<Integer> list = new ArrayList<>(x);
        helper(nums,i+map.get(nums[i]),new ArrayList<>(list));
        for(int c=1;c<=map.get(nums[i]);c++){
            list.add(nums[i]);
            helper(nums,i+map.get(nums[i]),new ArrayList<>(list));
        }
    }
}