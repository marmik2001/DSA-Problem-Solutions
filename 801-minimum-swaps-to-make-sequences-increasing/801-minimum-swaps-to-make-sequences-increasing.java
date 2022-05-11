class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] swap = new int[n], noSwap = new int[n];
        swap[0] = 1;
        for(int i=1;i<n;i++){
            swap[i] = n;
            noSwap[i] = n;
            if(nums1[i-1]<nums1[i]&&nums2[i-1]<nums2[i]){
                noSwap[i] = noSwap[i-1];
                swap[i] = swap[i-1]+1;
            }
            if(nums1[i-1]<nums2[i]&&nums2[i-1]<nums1[i]){
                noSwap[i] = Math.min(noSwap[i],swap[i-1]);
                swap[i] = Math.min(swap[i],noSwap[i-1]+1);
            }
        }
        return Math.min(swap[n-1],noSwap[n-1]);
    }
}