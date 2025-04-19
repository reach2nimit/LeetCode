class Solution {
public:
    vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    vector<vector<int>> mem;
    
    int dfs(vector<vector<int>>& matrix, vector<vector<int>>& mem, int i, int j, int &row, int &col){
        
        if(mem[i][j])
            return mem[i][j];
        
        mem[i][j] = 1;
                
        for(auto d : dirs){
            
            int x = i + d[0], y = j + d[1];
            
            if(x>=0 and y>=0 and x<row and y<col and matrix[x][y]>matrix[i][j])        
                mem[i][j] = max(mem[i][j], dfs(matrix, mem, x,y,row, col) + 1 );
        }
        
        return mem[i][j];
    }
    
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int row = matrix.size();
        int col = matrix[0].size();
        
        mem = vector<vector<int>>(row, vector<int> (col, 0));
        int ans = 1;

        for(int i=0; i<row; i++){
            for(int j = 0; j<col; j++){
                
               ans = max(ans, dfs(matrix, mem, i, j, row, col));
            }
        }
        return ans;
    }
};