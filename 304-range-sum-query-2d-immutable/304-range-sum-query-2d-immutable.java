class NumMatrix {
    int m,n;
    int[][] cumulativeRSum;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        cumulativeRSum = new int[m+1][n+1];
        for(int r=1;r<=m;r++)
            for(int c=0;c<n;c++)
                cumulativeRSum[r][c] = cumulativeRSum[r-1][c]+matrix[r-1][c];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int c=col1;c<=col2;c++)
            sum+=cumulativeRSum[row2+1][c]-cumulativeRSum[row1][c];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */