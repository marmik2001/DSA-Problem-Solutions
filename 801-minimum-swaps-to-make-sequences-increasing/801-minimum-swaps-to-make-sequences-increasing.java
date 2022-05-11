class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int swap = 1, noSwap = 0;
        for(int i=1;i<n;i++){
            int lSwap = i+1, lNoSwap = i+1;
            if(nums1[i-1]<nums1[i]&&nums2[i-1]<nums2[i]){
                lNoSwap = noSwap;
                lSwap = swap+1;
            }
            if(nums1[i-1]<nums2[i]&&nums2[i-1]<nums1[i]){
                lNoSwap = Math.min(lNoSwap,swap);
                lSwap = Math.min(lSwap,noSwap+1);
            }
            swap = lSwap;
            noSwap = lNoSwap;
        }
        return Math.min(swap,noSwap);
    }
}