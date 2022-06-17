class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] lessLeft = new int[n];
        int[] lessRight = new int[n];
        lessLeft[0] = -1;
        lessRight[n-1] = n;
        
        for(int i=1;i<n;i++){
            int p = i-1;
            while(p>=0&&heights[p]>=heights[i])
                p = lessLeft[p];
            lessLeft[i] = p;
        }
        for(int i=n-2;i>=0;i--){
            int p = i+1;
            while(p<n&&heights[p]>=heights[i])
                p = lessRight[p];
            lessRight[i] = p;
        }
        
        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(ans,heights[i]*(lessRight[i]-lessLeft[i]-1));
        return ans;
    }
}