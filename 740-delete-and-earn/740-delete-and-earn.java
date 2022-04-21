class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for(int i:nums)
            arr[i-1]++;
        int p1 = arr[0],p2 = Math.max(arr[0],arr[1]*2);
        for(int i=2;i<=10000;i++){
            int x = Math.max(p1+arr[i]*(i+1),p2);
            p1 = p2;
            p2 = x;
        }
        return p2;
    }
}