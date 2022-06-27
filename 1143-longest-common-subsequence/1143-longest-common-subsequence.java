class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()<text2.length())return longestCommonSubsequence(text2,text1);
        int[] dp = new int[text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            int save = 0;
            for(int j=1;j<=text2.length();j++){
                int temp = dp[j];
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[j] = 1 + save;
                else 
                    dp[j] = Math.max(dp[j-1],dp[j]);
                save = temp;
            }
        }
        return dp[text2.length()];
    }
}