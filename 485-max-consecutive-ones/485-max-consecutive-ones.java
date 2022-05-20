class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0,count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) 
        	    result = Math.max(++count, result);
            else count = 0;
        }
        return result;
    }
}