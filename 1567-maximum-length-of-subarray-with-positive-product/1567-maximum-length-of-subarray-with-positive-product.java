class Solution {
    public int getMaxLen(int[] nums) {
        boolean positive = true;
        int start = -1,lenMax = 0,firstNegativeIndex = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                start = i;
                firstNegativeIndex = -1;
                positive = true;
            }else{
                if(nums[i]<0)
                    positive=!positive;
                if(positive)
                    lenMax = Math.max(lenMax,i-start);
                else{
                    if(firstNegativeIndex!=-1)
                        lenMax = Math.max(lenMax,i-firstNegativeIndex);
                    else
                        firstNegativeIndex = i;                    
                }
            }
        }
        return lenMax;
    }
}