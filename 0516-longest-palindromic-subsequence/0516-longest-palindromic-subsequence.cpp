class Solution {
public:
    int longestPalindromeSubseq(string s) {
        string reverse = "";

        for(int i=s.size()-1; i>=0; i--)
            reverse+=s[i];

        vector<vector<int>> table (s.size()+1, vector<int>(s.size()+1,0));

        for(int i=1; i<s.size()+1; i++){
            for(int j=1; j<s.size()+1; j++){
                if(s[i-1]==reverse[j-1])
                    table[i][j] = 1 + table[i-1][j-1];
                else
                    table[i][j] = max(table[i-1][j], table[i][j-1]);
            }
        }
        return table[s.size()][s.size()];

    }
};