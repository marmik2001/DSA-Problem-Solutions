class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int[] x:matrix)
            Arrays.fill(x,Integer.MAX_VALUE);
        for(int i=0;i<n;i++)
            matrix[i][i] = 0;
        for(int[] edge:edges){
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(matrix[i][k]==Integer.MAX_VALUE||i==k)continue;
                for(int j=0;j<n;j++)
                    matrix[i][j] = (int)Math.min(matrix[i][j],(long)matrix[i][k]+matrix[k][j]);
            }
        }
        int count = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<n;i++){
            int localCount = 0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(matrix[i][j]<=distanceThreshold)localCount++;
            }
            if(localCount<=count){
                count = localCount;
                ans = i;
            }
        }
        return ans;
    }
}