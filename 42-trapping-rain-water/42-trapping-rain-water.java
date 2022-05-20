class Solution {
    public int trap(int[] height) {
        int result = 0,i = 0, j = height.length-1, leftMax = 0, rightMax = 0;
        while(i<j){
            if(height[i]<=height[j]){
                if(height[i]>=leftMax)
                    leftMax = height[i];
                else 
                    result+=(leftMax-height[i]);
                i++;
            }else{
                if(height[j]>=rightMax)
                    rightMax = height[j];
                else 
                    result+=(rightMax-height[j]);
                j--;
            }
        }
        return result;
    }
}