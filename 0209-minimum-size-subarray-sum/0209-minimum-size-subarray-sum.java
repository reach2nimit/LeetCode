class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0, currSum = 0;
        int result = Integer.MAX_VALUE;

        for(int right = 0; right<nums.length; right++){

            currSum+=nums[right];

            while(currSum>=target){

                result = Math.min(result, right - left + 1);
                currSum-=nums[left];
                left++;
            }
            
        }
        if(result == Integer.MAX_VALUE)
            return 0;

        return result;
    }
}