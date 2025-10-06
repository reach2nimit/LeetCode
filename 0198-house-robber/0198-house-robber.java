class Solution {
    public int rob(int[] nums) {

        int len = nums.length;
        if(len==1)
            return nums[0];
        
        int[] dp = new int[len];

        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        int prevRob = nums[0];
        int maxRob = Math.max(nums[0], nums[1]);

        for(int i=2; i<len; i++){
            int tempRob = Math.max(maxRob, nums[i]+prevRob);
            prevRob = maxRob;
            maxRob = tempRob;
        }
        return maxRob;
    }
}