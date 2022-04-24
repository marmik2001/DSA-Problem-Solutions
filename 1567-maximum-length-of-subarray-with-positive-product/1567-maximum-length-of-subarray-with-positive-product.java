class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen = 0, curMax = 0, curMin=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                curMax = 0;
                curMin = 0;
            }
            else{
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