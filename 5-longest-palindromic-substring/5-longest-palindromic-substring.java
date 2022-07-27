class Solution {
    int[] ans;
    int max;
    public String longestPalindrome(String s) {
        ans = new int[2];
        max = 1;
        for(int i=1;i<s.length();i++) {
            max(s, i, i);
            max(s, (i - 1), i);
        }
        return s.substring(ans[0],ans[1]+1);
    }
    private void max(String s, int i, int j){
        int count = 0;
        if(i==j){
            count++;
            i--;j++;
        }
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            count+=2;
            i--;j++;
        }
        if(count>max) {
            max = Math.max(max, count);
            ans[0] = i+1;
            ans[1] = j-1;
        }
    }
}