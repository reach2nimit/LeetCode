class Solution {
private:
    string expandAroundCentre(int left, int right, string value) {
        int i = left, j = right;
        while (i >= 0 && j < value.size() && value[i] == value[j]){
            i--;
            j++;
        }
        return value.substr(i+1, j-i-1);
    }

public:
    string longestPalindrome(string s) {

        string result = "";

        for (int i = 0; i < s.size(); i++) {
            string oddLength = expandAroundCentre(i, i, s);
            if (oddLength.size() > result.size())
                result = oddLength;

            string evenLength = expandAroundCentre(i, i + 1, s);
            if (evenLength.size() > result.size())
                result = evenLength;
        }
        return result;
    }
};