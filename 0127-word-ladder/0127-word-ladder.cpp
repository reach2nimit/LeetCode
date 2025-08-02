class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> st;
        
        for(auto word: wordList)
            st.insert(word);
        
        if(st.find(endWord)==st.end())
            return 0;
        
        int steps =1;
        
        queue<string> q;
        q.push(beginWord);
        
        while(!q.empty()){
            
            int n = q.size();
            
            while(n--){
                
                string curr = q.front();
                q.pop();
                
                if(curr == endWord)
                    return steps;
                
                for(int i=0; i< curr.size(); i++){
                    
                    string temp = curr;
                    
                    for(char c ='a'; c<='z'; c++){
                        temp[i] = c;
                        
                        if(temp == curr) continue;
                        
                        
                        if(st.find(temp)!=st.end()){
                            q.push(temp);
                            st.erase(temp);
                        }
                        
                    }
                }

            }
            
            steps++;
        }
     return 0;   
    }
};