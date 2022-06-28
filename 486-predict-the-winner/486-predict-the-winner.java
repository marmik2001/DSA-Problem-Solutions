class Solution {
    private boolean tie;
    public boolean PredictTheWinner(int[] nums) {
        tie=false;
        return canP1Win(nums,0,nums.length-1,0,0)||tie;
    }
    private boolean canP1Win(int[] nums, int i, int j, int score1, int score2){
        if(i==j){
            if(score1+nums[i]>score2) return true;
            if(score1+nums[i]==score2)tie=true;
            return false;
        }
        return !canP1Win(nums,i+1,j,score2,score1+nums[i])||!canP1Win(nums,i,j-1,score2,score1+nums[j]);
    }
}