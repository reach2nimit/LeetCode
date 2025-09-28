class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        if(obstacleGrid == null || obstacleGrid[0][0]==1)
            return 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){

                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }

                if(i==0 || j==0){
                    dp[i][j]= (i==0) ? dp[i][j-1] : dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[row-1][col-1];
    }
}