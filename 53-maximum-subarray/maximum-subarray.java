class Solution {
    public int maxSubArray(int[] nums) {
       int currSum = nums[0], result = nums[0];

       for(int i=1; i<nums.length;i++){
        currSum = Math.max(nums[i], currSum + nums[i]);
        result = Math.max(result, currSum);
       } 

       return result;
    }
}