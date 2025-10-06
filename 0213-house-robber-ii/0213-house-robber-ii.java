class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        if(len==1)
            return nums[0];
        
        int prevRob=0, maxRobFirst = 0, maxRobSecond = 0;

        for(int i=0; i<len-1; i++){
            int tempRob = Math.max(maxRobFirst, prevRob + nums[i]);
            prevRob=maxRobFirst;
            maxRobFirst= tempRob;
        }

        prevRob=0;
        for(int i=1; i<len; i++){
            int tempRob = Math.max(maxRobSecond, prevRob + nums[i]);
            prevRob=maxRobSecond;
            maxRobSecond= tempRob;
        }

        return Math.max(maxRobSecond, maxRobFirst);
    }
}