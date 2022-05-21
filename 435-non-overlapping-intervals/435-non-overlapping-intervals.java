class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[1],o2[1]));
        int startLimit = intervals[0][1],count = 1;
        for(int[] x:intervals){
            if(x[0]>=startLimit){
                count++;
                startLimit = x[1];
            }   
        }
        return intervals.length - count;
    }
}