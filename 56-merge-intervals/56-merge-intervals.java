class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        int[] latest = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=latest[1])
                latest[1] = Math.max(intervals[i][1],latest[1]); 
            else{
                ans.add(latest);
                latest = intervals[i];
            }
        }
        ans.add(latest);
        int[][] x = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            x[i] = ans.get(i);
        }
        return x;
    }
}