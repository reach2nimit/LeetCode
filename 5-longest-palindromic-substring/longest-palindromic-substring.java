class Solution {

    String expandString(String s, int i, int j){

        int left = i, right = j;
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right );
    }
    public String longestPalindrome(String s) {
        String result = "";

        for(int i = 0; i<s.length(); i++){
            String oddLength = expandString(s, i, i);
            if(oddLength.length() > result.length())
                result = oddLength;

            String evenLength = expandString(s, i, i+1);
            if(evenLength.length() > result.length())
                result = evenLength;

        }
        return result;
    }
}