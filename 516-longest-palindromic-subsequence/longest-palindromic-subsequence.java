class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int len = s.length();
        //String revString = (new StringBuilder(s)).reverse().toString();

        int[][] dp = new int[len+1][len+1];

        for(int i=1; i<len+1; i++){
            for(int j=1; j<len+1; j++){

                if(s.charAt(i-1)==s.charAt((len)-j))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[len][len];
    }
}