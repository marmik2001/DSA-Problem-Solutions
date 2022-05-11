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
                int temp = nums[i-1];
                nums[i-1] = nums[index];
                nums[index] = temp;
                for(int j=i,k=0;k<(n-i)/2;j++){
                    temp = nums[j];
                    nums[j] = nums[n-j+i-1];
                    nums[n-j+i-1] = temp;
                    k++;
                }
                break;
            }
        }
        if(!entry){
            for(int i=0;i<n/2;i++){
                int temp = nums[i];
                nums[i] = nums[n-i-1];
                nums[n-i-1] = temp;
            }
        }
    }
}