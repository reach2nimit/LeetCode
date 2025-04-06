class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int maxSum = nums[0], minSum = nums[0];
        int currMax = 0, currMin =0;
        int totalSum = 0;

        for(int num : nums){

            currMax = Math.max(num + currMax, num);
            currMin = Math.min(currMin + num, num);

            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(currMin, minSum);

            totalSum +=num;
        }

        return maxSum>0 ? Math.max(maxSum, totalSum-minSum) : maxSum;
    }
}