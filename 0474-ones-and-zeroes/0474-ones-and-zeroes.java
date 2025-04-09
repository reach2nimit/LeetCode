class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str : strs){

            int[] count = countZeroOne(str);
            int skip=0, notSkip=0;
            for(int zero = m; zero>=count[0]; zero --){
                for(int one = n; one>=count[1]; one--){
                    notSkip = 1 + dp[zero-count[0]][one-count[1]];
                    skip = dp[zero][one];
                    dp[zero][one] = Math.max(notSkip, skip);
                }
            }
        }
        return dp[m][n];
        
    }

    private int[] countZeroOne(String str){
        int [] count = new int[2];
        for(char ch : str.toCharArray()){
            if(ch=='0')
                count[0]++;
            else
                count[1]++;
        }
        
        return count;
    }
}