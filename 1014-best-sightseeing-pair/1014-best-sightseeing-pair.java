class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max=0,start = values[0]+0;
        for(int j=1;j<values.length;j++){
            max = Math.max(max,start+values[j]-j);
            start = Math.max(start,values[j]+j);
        }
        return max;
    }
}