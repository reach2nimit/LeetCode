class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int len = s.length();
        String revString = (new StringBuilder(s)).reverse().toString();

        int[][] dp = new int[len+1][len+1];

        int[] prev = new int[len+1];
        

        for(int i=1; i<len+1; i++){
            int[] curr = new int[len+1];
            for(int j=1; j<len+1; j++){

                if(s.charAt(i-1)==revString.charAt(j-1))
                    curr[j] = 1+prev[j-1];
                else
                    curr[j] = Math.max(curr[j-1], prev[j]);

            }
            prev=curr;
        }

        return prev[len];
    }
}