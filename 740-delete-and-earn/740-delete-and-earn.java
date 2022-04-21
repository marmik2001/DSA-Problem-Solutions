class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for(int i:nums)
            arr[i]+=i;
        
        for(int i=2;i<=10000;i++){
            arr[i] = Math.max(arr[i-1],arr[i-2]+arr[i]);
        }
        return arr[10000];
    }
}