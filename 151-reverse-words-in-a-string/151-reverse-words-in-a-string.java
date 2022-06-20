class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i=arr.length-1;i>0;i--){
            String x = arr[i].trim();
            str.append(x);
            if(!x.equals(""))
                str.append(' ');
        }
        str.append(arr[0]);
        return str.toString();
    }
}