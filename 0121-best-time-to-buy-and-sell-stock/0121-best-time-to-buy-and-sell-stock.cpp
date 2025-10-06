class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int ans = 0, curr = prices[0];
        int len = prices.size();
        if(len==1) return ans;
        
        for(int i=1;i<len;i++){
            
            if(prices[i]-curr<0)
                curr = prices[i];
            else
                ans = max(ans,prices[i]-curr);
        }
        return ans;
    }
};