class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        int[] l = new int[26], r = new int[26];
        Arrays.fill(l,s.length());
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            l[c-'a'] = Math.min(l[c-'a'],i);
            r[c-'a'] = i;
        }
        int right = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(l[c-'a']!=i)continue;
            int x = validRight(s,l,r,l[c-'a'],r[c-'a']);
            if(x==-1)continue;
            if(x>right)ans.add("");
            right = x;
            ans.set(ans.size()-1,s.substring(i,x+1));
        }
        return ans;
    }
    private int validRight(String s, int[] l, int[] r, int i, int j){
        int right=j;
        for(int x=i+1;x<right;x++){
            char c = s.charAt(x);
            if(l[c-'a']<i)return -1;
            right = Math.max(right,r[c-'a']);
        }
        return right;
    }
}