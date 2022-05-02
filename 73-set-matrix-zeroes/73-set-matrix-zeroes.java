class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean zero_col = false;
        for(int r=0;r<m;r++){
            if(matrix[r][0]==0)
                zero_col = true;
            for(int c=1;c<n;c++){
                if(matrix[r][c]==0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for(int r=1;r<m;r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < n; c++)
                    matrix[r][c] = 0;
            }
        }
        for(int c=1;c<n;c++){
            if(matrix[0][c]==0){
                for(int r=1;r<m;r++)
                    matrix[r][c]=0;
            }
        }
        if(matrix[0][0]==0){
            for(int c=1;c<n;c++)
                matrix[0][c] =0;
        }
        if(zero_col){
            for(int r=0;r<m;r++)
                matrix[r][0]=0;
        }
    }
}