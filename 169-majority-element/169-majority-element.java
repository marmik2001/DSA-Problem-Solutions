class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0],count=0;
        for(int i:nums){
            if(i==major)count++;
            else if(count==0)major=i;
            else count--;
        }
        return major;
    }
}