class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {

       int row = grid.length; int col = grid[0].length;
       int[][] dp = new int[row][col];

       for(int i = 0; i<row; i++){
        for(int j=0; j<col; j++){

            if(grid[i][j]==1)
                dp[i][j]=0;
            else if(i==0 && j==0)
                dp[i][j]=1;
            else if(i == 0 || j==0)
                dp[i][j] = (i==0) ? dp[i][j-1] : dp[i-1][j];
            else
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
       }
        return dp[row-1][col-1];
    }
}