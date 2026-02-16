class Solution {
    public int minAddToMakeValid(String s) {
        int openBraces = 0, closedBraces = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                openBraces++;
            else{
                if(openBraces>0)
                    openBraces--;
                else
                    closedBraces++;
            } 
        }

        return closedBraces + openBraces;
    }
}