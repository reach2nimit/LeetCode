class Solution {
public:
    bool isValid(string s) {
        stack<char> st;

        for(int i=0; i<s.length(); i++){

            char temp =s[i];

            if(temp=='(' || temp=='[' || temp=='{' ){
                st.push(temp);
                continue;
            }

            if(temp==')' && (st.empty() || st.top()!='('))
                return false;
            else if(temp==']' && (st.empty() || st.top()!='['))
                return false;
            else if(temp=='}' && (st.empty() || st.top()!='{'))
                return false;
            st.pop();    
        }

        if(!st.empty())
            return false;
        return true;
    }
};