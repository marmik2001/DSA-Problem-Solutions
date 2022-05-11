class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean entry = false;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                entry = true;
                int index = i;
                int lo = i,hi = n-1;
                while(lo<=hi){
                    int mid = lo+(hi-lo)/2;
                    if(nums[mid]<=nums[i-1])
                        hi = mid-1;
                    else if(nums[mid]>nums[i-1]&&(mid==hi||nums[mid+1]<=nums[i-1])){
                        index = mid;
                        break;
                    }else
                        lo = mid+1;
                }
                swap(nums,index,i-1);
                for(int k=0;k<(n-i)/2;k++)
                    swap(nums,i+k,n-k-1);
                break;
            }
        }
        if(!entry){
            for(int i=0;i<n/2;i++)
                swap(nums,i,n-i-1);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}