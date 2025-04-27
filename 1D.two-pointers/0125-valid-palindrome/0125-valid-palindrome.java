class Solution {
    private char toLowerCase(char c){
        if(c>='A' && c<='Z')
            return (char)('a' + (c - 'A'));
        else
            return c;
    }
    public boolean isPalindrome(String s) {
        int len = s.length();
        String temp = "";

        for(int i=0; i<len; i++){
            char curr = s.charAt(i);

            if(curr>='a' && curr<='z')
                temp+=curr;
            else if(curr>='A' && curr<='Z')
                temp+=toLowerCase(curr);
            else if(curr>='0' && curr<='9')
                temp+=curr;
        }
        System.out.println(temp);
        int left=0, right=temp.length()-1;

        while(left<len && right>=0 && left<right){
            if(temp.charAt(left)!=temp.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}