class Solution {
    List<List<Integer>> solution;
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i:nums)
            arr.add(i);
        solution = new ArrayList<>();
        helper(arr,0);
        return solution;
    }
    private void helper(ArrayList<Integer> nums, int i){
        if(i==nums.size()){
            solution.add(new ArrayList<>(nums));
            return;
        }
        for(int j=i;j<nums.size();j++){
            swap(nums,i,j);
            helper(nums,i+1);
            swap(nums,i,j);
        }
    }
    private void swap(ArrayList<Integer> nums, int i,int j){
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
}