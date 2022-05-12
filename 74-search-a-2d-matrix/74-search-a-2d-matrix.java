class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int col = n-1;
        for(int row = 0;row<m;row++){
            int x = bSearch(matrix,target,row,0,col);
            if(x==-1)return false;
            if(matrix[row][x]==target)return true;
            col = x;
        }
        return false;
    }
    private int bSearch(int[][] matrix, int target,int row, int c1,int c2){
        while(c1<=c2){
            int mid = (c1+c2)/2;
            if(matrix[row][mid]==target)return mid;
            else if(matrix[row][mid]>target)
                c2 = mid-1;
            else{
                if(mid==c2||(mid+1<=c2&&matrix[row][mid+1]>target))
                    return mid;
                else if(mid+1>c2)return -1;
                else
                    c1 = mid+1;
            }
        }
        return -1;
    }
}