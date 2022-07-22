class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0,j=0,maxLen=0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)&&map.get(c)>=i){
                maxLen = Math.max(maxLen,j-i);
                i = map.get(c)+1;    
            }
            map.put(c,j);
            j++;
        }
        return Math.max(maxLen,j-i);
    }
}