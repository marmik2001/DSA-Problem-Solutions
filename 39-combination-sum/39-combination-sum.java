class Solution {
    List<List<Integer>> solution;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solution = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return solution;
    }
    private void helper(int[] candidates, int i, int target, List<Integer> x) {
        if (i == candidates.length) {
            if (target == 0) solution.add(new ArrayList<>(x));
            return;
        }
        if (target < 0) return;
        helper(candidates, i+1, target, x);
        x.add(candidates[i]);
        helper(candidates, i, target - candidates[i], x);
        x.remove(x.size() - 1);
    }
}