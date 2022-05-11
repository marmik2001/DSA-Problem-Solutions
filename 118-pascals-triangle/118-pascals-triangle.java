class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> old = new ArrayList<>();
        old.add(1);
        ans.add(old);
        if(numRows==1)return ans;
        old = new ArrayList<>();
        old.add(1);
        old.add(1);
        ans.add(old);
        numRows-=2;
        while(numRows-->0){
            List<Integer> latest = new ArrayList<>();
            latest.add(1);
            for(int i=1;i<old.size();i++)
                latest.add(old.get(i)+old.get(i-1));
            latest.add(1);
            ans.add(latest);
            old = latest;
        }
        return ans;
    }
}