class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int i=0,j=n-1;
        for(int x:nums){
            if(x%2==0)
                arr[i++]=x;
            else
                arr[j--]=x;
        }
        return arr;
    }
}