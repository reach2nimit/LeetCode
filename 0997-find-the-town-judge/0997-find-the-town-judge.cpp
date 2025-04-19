class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        
        vector<int> util(n+1);
        
        for(int i=0;i<=n; i++)
            util[i]=0;
        
        for(int i=0; i<trust.size();i++){
            
            util[trust[i][0]]-=1;
            util[trust[i][1]]+=1;
        }
        
        for(int i=1; i<=n; i++)
            if(util[i]==n-1)
                return i;
        
        return -1;
            
        
    }
};