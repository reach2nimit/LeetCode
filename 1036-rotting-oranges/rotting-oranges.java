class Solution {
    public int orangesRotting(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int time = 0;
        int fresh=0, converted=0;

        Queue<int[]> queue = new LinkedList();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j,0});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!queue.isEmpty()){
            int qSize = queue.size();
            
            for(int i=0; i<qSize; i++){

                int[] curr = queue.remove();
                int x = curr[0];
                int y = curr[1];
                time = curr[2];

                for(int j=0; j<4; j++){
                     int a = x + dx[j];
                     int b = y + dy[j];

                     if(a>=0 && a<row && b>=0 && b<col && grid[a][b]==1){
                        grid[a][b]=2;
                        converted++;
                        queue.add(new int[]{a, b , time+1});
                     }
                }
            }
        }

        if(fresh==converted)
            return time;

        return -1;
    }
}