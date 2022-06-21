class Solution {
    public int strStr(String haystack, String needle) {
        int[] preprocess = preprocess(needle);
        int i=0,j=0;
        while(i<haystack.length()&&j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;j++;
            }else if(j>0)
                j = preprocess[j-1];
            else 
                i++;
        }
        return j==needle.length()?i-j:-1;
    }
    private int[] preprocess(String s){
        int[] arr = new int[s.length()];
        int i=1,j=0;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                arr[i] = j+1;
                i++;j++;
            }
            else if(j>0)
                j = arr[j-1];
            else
                i++;
        }
        return arr;
    }
}