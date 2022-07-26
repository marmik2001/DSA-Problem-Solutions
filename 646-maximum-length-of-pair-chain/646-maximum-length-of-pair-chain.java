class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparingInt(o->o[0]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        for(int i=1;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]>=pairs[i][0])continue;
                dp[i] = Math.max(dp[i],dp[j]);
            }
            dp[i]++;
        }
        int max = 0;
        for(int i:dp)
            max = Math.max(max,i);
        return max;
    }
}