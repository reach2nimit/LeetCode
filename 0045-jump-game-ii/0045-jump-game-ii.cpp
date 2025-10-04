class Solution {
public:
    int jump(vector<int>& nums) {
        
        int jump=0, local=0, farthest=0;
        
        for(int i=0;i<size(nums)-1;i++){
            
            farthest = max(farthest, i+nums[i]);
            
            if(i==local){
                local=farthest;
                jump++;
            }
        }
        return jump;
    }
};