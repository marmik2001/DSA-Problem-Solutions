class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n-1, pivot = 0;
        while(lo<hi){
            if(nums[lo]<nums[hi]){
                pivot=lo;
                break;
            }
            int mid = (lo+hi)/2;
            if(nums[mid]>=nums[lo])
                lo = mid+1;
            else if(nums[mid-1]<nums[mid])
                hi = mid-1;
            else{
                pivot = mid;
                break;
            }
        }
        if(pivot==0)pivot = lo;
        int i = Arrays.binarySearch(nums,(0),pivot,target);
        if(i>=0)return i;
        else {
            int x= Arrays.binarySearch(nums,pivot,nums.length,target);
            return x>=0?x:-1;
        }
    }
}