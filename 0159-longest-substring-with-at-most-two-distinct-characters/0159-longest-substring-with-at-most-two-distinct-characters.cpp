class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        
        int k =2;
        int left=0, right=0;
        vector<int> track(128,0);
        int maxLength = 0;
        int uniqueChar=0;
        
        
        while(right<s.length()){
            
            if(track[s[right]]==0)
                uniqueChar++;
            
            track[s[right]]++;
            
            if(uniqueChar>k){
                
                while(uniqueChar>k){
                    
                    track[s[left]]--;
                    
                    if(track[s[left]]==0)
                        uniqueChar--;
                    left++;
                }
                
            }
            
            maxLength=max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
};