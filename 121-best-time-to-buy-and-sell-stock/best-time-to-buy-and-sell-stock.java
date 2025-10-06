class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=0)
            return 0;
        
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;

        for(int price : prices){
            if(minPrice>=price)
                minPrice = price;
            else{
                int profit = price - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }
}