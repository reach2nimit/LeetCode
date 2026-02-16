class Solution {
    public int minAddToMakeValid(String s) {
        int cntA = 0, cntB = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                cntA++;
            else if(ch == ')' && cntA>0)
                cntA--;
        }
        for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if( ch == ')')
                cntB++;
            else if(ch == '(' & cntB>0)
                cntB--;
        }

        return Math.abs(cntA) +  Math.abs(cntB);
    }
}