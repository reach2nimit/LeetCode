class Solution {
    static private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    private int dfs(int[][] matrix, int[][]dp, int row, int col){

        if(dp[row][col]!=0)
            return dp[row][col];
        
        dp[row][col]=1;

        for(int k=0; k<4; k++){
            int newRow = row + directions[k][0];
            int newCol = col + directions[k][1];

            if(newRow>=0 && newCol>=0 && newRow<matrix.length && newCol<matrix[0].length &&
               matrix[newRow][newCol] > matrix[row][col])
               dp[row][col] +=(dfs(matrix, dp, newRow, newCol)%modulo);
        }

        return dp[row][col];
    }  
    private static int modulo = (int)(1e9+7);
    public int countPaths(int[][] matrix) {
        
        int row = matrix.length, col = matrix[0].length;
        int [][] dp = new int[row][col];
        int result = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                result = (result + (dfs(matrix, dp, i, j)%modulo))%modulo;
            }
        }

        return result;
    }
}