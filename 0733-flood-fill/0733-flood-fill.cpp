class Solution {
public:
    
     void dfs(vector<vector<int>>& image, int r, int c, int col, int pre){
         
         if(r<0||c<0||r>=image.size()||c>=image[r].size()||image[r][c]!=pre)
             return;
         image[r][c]=col;
         dfs(image,r-1,c,col,pre);
         dfs(image,r+1,c,col,pre);
        dfs(image,r,c-1,col,pre);
         dfs(image,r,c+1,col,pre);
     }
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor)
            return image;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        
        return image;
        
    }
};