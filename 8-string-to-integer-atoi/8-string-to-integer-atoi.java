class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0)return 0;
        StringBuilder ans = new StringBuilder();
        int i=0;
        if(s.charAt(i)=='+'||s.charAt(i)=='-'){
            if(s.charAt(i++)=='-')
                ans.append('-');
        }
        boolean flag = false;
        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            if(s.charAt(i)!='0')flag = true;
            if(flag)
                ans.append(s.charAt(i));
            i++;
        }
        String str = ans.toString();
        if(str.length()==0||(str.length()==1&&str.charAt(0)=='-'))return 0;
        if(str.length()>11){
            if(str.charAt(0)=='-')return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        long x = Long.parseLong(str);
        return x>Integer.MAX_VALUE?Integer.MAX_VALUE:(x<Integer.MIN_VALUE?Integer.MIN_VALUE:(int)x);
    }
}