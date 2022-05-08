class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(nums,new ArrayList<>(),0);
        return ans;
    }
    private void helper(int[] nums,List<Integer> list,int i){
        if(i==nums.length){
            ans.add(list);
            return;
        }
        List<Integer> l = new ArrayList<>(list);
        list.add(nums[i]);
        helper(nums,l,i+1);
        helper(nums,list,i+1);
    }
}