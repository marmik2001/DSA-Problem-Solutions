class Solution {
    List<List<String>> solution;
    public List<List<String>> solveNQueens(int n) {
        solution = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] x:board)
            Arrays.fill(x,'.');
        helper(board,n,0,new HashSet<>());
        return solution;
    }
    private void helper(char[][] arr, int n, int i, HashSet<Integer> rowsCovered){
        if(i==n){
            List<String> sol = new ArrayList<>();
            for(char[] x:arr)
                sol.add(String.valueOf(x));
            solution.add(sol);
            return;
        }
        for(int row=0;row<n;row++){
            if(rowsCovered.contains(row))continue;
            if(checkDiagonals(arr,row,i,n)){
                arr[row][i] = 'Q';
                rowsCovered.add(row);
                helper(arr,n,i+1,rowsCovered);
                rowsCovered.remove(row);
                arr[row][i] = '.';
            }    
        }
    }
    private boolean checkDiagonals(char[][] arr, int row, int col, int n){
        int r = row-1, c = col - 1;
        while(r>=0&&c>=0){
            if(arr[r][c]=='Q')return false;
            r--;
            c--;
        }
        r = row+1;
        c = col-1;
        while(r<n&&c>=0){
            if(arr[r][c]=='Q')return false;
            r++;
            c--;
        }
        return true;
    }
}