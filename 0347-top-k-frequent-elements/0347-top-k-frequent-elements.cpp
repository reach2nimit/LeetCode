class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int,int> mp;
        
        for(int i=0;i<nums.size();i++)
            mp[nums[i]]++;
        
        priority_queue<pair<int,int>> pq;
        
        for(auto x : mp){
            int num = x.first, freq = x.second;
            pq.push({freq,num});
        }
        
        vector<int> res;
        
        while(k--){
            res.push_back(pq.top().second);
            pq.pop();
        }
        return res;
    }
};