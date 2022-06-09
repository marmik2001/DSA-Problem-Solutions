class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n-1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if((hi-lo)%4==0){
                if(nums[mid]==nums[mid+1])
                    lo = mid+2;
                else if(nums[mid]==nums[mid-1])
                    hi = mid-2;
                else return nums[mid];
            }else{
                if(nums[mid]==nums[mid-1])
                    lo = mid+1;
                else if(nums[mid]==nums[mid+1])
                    hi = mid-1;
                else return nums[mid];
            }
        }
        return nums[lo];
    }
}