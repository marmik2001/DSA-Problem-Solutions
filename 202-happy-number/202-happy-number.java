class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> processed = new HashSet<>();
        while(!processed.contains(n)){
            if(n==1)return true;
            processed.add(n);
            n = sumOfSquaresD(n);
        }
        return false;
    }
    private int sumOfSquaresD(int n){
        int ans = 0;
        while(n>0){
            ans+=(n%10)*(n%10);
            n/=10;
        }
        return ans;
    }
}