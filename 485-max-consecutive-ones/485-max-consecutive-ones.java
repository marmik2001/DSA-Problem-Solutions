class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int j = i;
                while(j<nums.length&&nums[j]==1)j++;
                max = Math.max(max,j-i);
                i=j-1;
            }
        }
        return max;
    }
}