class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                count++;
            else if(ch == ')'){
                if(count==0)
                    continue;
                count--;
            }
            sb.append(ch);
        }

        count= 0;
        StringBuilder result = new StringBuilder();
        for(int i = sb.length()-1; i>=0 ; i--){
            char ch = sb.charAt(i);
            if(ch == ')')
                count++;
            else if(ch == '('){
                if(count == 0)
                    continue;
                count--;
            }
            result.append(ch);
        }

        return result.reverse().toString();
    }
}