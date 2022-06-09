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
        if(pivot==0){
            int ans = Arrays.binarySearch(nums,target);
            return ans>=0?ans:-1;
        }
        int ans = Arrays.binarySearch(nums,0,pivot,target);
        if(ans>=0)return ans;
        ans = Arrays.binarySearch(nums,pivot,n,target);
        if(ans>=0)return ans;
        return -1;
    }
}