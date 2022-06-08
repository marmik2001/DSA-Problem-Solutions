class Solution {
    class Node{
        boolean word;
        Node[] next;
        Node(){
            word = false;
            next = new Node[26];
        }
    }
    Node root;
    HashMap<String,List<String>> dp = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Node();
        ArrayList<String> baseCase = new ArrayList<>();
        baseCase.add("");
        dp.put("",baseCase);
        for(String word:wordDict){
            Node x = root;
            for(char c:word.toCharArray()){
                int index = c-'a';
                if(x.next[index]==null)
                    x.next[index] = new Node();
                x = x.next[index];
            }
            x.word = true;
        }
        return helper(s);
    }
    private List<String> helper(String s){
        if(dp.containsKey(s))return dp.get(s);
        List<String> ans= new ArrayList<>();
        Node x = root;
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(x.next[index]==null)
                break;
            x = x.next[index];
            if(x.word){
                List<String> sub = helper(s.substring(i+1));
                for(String str:sub) {
                    if(str.equals(""))ans.add(s.substring(0, i + 1));
                    else ans.add(s.substring(0, i + 1) + " " + str);
                }
            }
        }
        dp.put(s,ans);
        return ans;
    }
}