class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0, curMax = 0, curMin=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                curMax = 0;
                curMin = 0;
            }
            else{ 
                /*first solved using cases nums[i] > 0 and < 0 then realized since
                we'll be swapping we can handle all in the following two lines*/ 
                if(curMin!=0)curMin++;
                    curMax++;
                if(nums[i]<0){
                    int temp = curMax;
                    curMax = curMin;
                    curMin = temp;
                }
                maxLen = Math.max(curMax,maxLen); 
            }
        }
        return maxLen;
    }
}