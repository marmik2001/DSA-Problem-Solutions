class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i])stack.pop();  
            arr[i][0] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i])stack.pop();  
            arr[i][1] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int local = heights[i];
            if(arr[i][0]!=-1)
                local+=heights[i]*(i-arr[i][0]-1);
            else
                local+=heights[i]*i;
            if(arr[i][1]!=-1)
                local+=heights[i]*(arr[i][1]-i-1);
            else
                local+=heights[i]*(n-i-1);
            ans = Math.max(ans,local);
        }
        return ans;
    }
}






