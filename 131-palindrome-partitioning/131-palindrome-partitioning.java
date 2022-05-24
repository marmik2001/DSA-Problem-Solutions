class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> solution=new ArrayList<>();
        if(s.equals("")){
            List<String> x = new ArrayList<>();
            solution.add(x);
        }
        for(int i=1;i<=s.length();i++){
            String s1 = s.substring(0,i);
            if(isPalindrome(s1)){
                List<List<String>> child_solution = partition(s.substring(i));
                for(List<String> x:child_solution){
                    x.add((0),s1);
                    solution.add(x);
                }
            }
        }
        return solution;
    }
    private boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}