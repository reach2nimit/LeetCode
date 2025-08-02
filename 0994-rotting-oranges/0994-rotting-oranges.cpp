class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int minutes=-1,count=0;
        queue<pair<int,int>> q;
        
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                
                if(grid[i][j]){
                    count++;
                    if(grid[i][j]==2){
                        q.push(make_pair(i,j));
                    }
                }
            }
        }
        
        int dx[4]={0,0,1,-1};
        int dy[4]={1,-1,0,0};
        
        if(q.empty()){
            if(!count)
                return 0;
            else 
                return -1;
        }
            
        
        while(!q.empty()){
            
            int n = q.size();
            count-=n;
            
            while(n--){
                
                int x=q.front().first;
                int y=q.front().second;
                q.pop();
                
                for(int i=0;i<4;i++){
                    
                    int nx=x+dx[i],ny=y+dy[i];
                    
                    if(nx<0||ny<0||nx>=grid.size()||
                       ny>=grid[0].size()||grid[nx][ny]!=1)
                        continue;
                    
                    grid[nx][ny]=2;
                    q.push(make_pair(nx,ny));
                    
                }
            }
            minutes++;
        }
        return (count==0)?minutes:-1;
    }
};