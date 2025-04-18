class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][5];

        for(int[] row : memo){
            Arrays.fill(row,-1);
        }

        return solve(prices, 0, 4, memo);
    }

    private int solve(int[] prices, int day, int txn, int[][] memo){

        if(day==prices.length || txn==0)
            return 0;
        
        if(memo[day][txn]!=-1)
            return memo[day][txn];
        
        int sol1= solve(prices, day+1, txn, memo);
        int sol2=0;

        if(txn%2==0)
            sol2 = -prices[day] + solve(prices, day+1, txn-1, memo);
        else
            sol2 = prices[day] + solve(prices, day +1, txn-1, memo);
        
        memo[day][txn] = Math.max(sol1, sol2);

        return memo[day][txn];
        
    }
}