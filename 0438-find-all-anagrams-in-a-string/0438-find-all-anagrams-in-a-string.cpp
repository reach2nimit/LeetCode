class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> ans;
        
        int sSize = s.size(), pSize = p.size();
        
        if(sSize<pSize)
            return ans;
        
        vector<int> pArr(26,0), sArr(26,0);
        
        for(int i=0;i<pSize;i++)
            pArr[p[i]-'a']++;
        
       for(int i=0; i<sSize; i++){
            
            sArr[s[i]-'a']++;
            
            if(i>=pSize-1){
                
                if(pArr==sArr)
                    ans.push_back(i-pSize+1);
               sArr[s[i-pSize+1]-'a']--;
            }
        }
       return ans; 
    }
};