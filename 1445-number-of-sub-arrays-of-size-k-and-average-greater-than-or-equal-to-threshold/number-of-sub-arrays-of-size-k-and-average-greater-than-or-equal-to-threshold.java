class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int result = 0;
        int currSum = 0, left = 0;

        for(int right = 0; right<nums.length; right++){

            if((right - left + 1) > k){
                currSum-=nums[left];
                left++;
            }
            currSum+=nums[right];

            if((right - left + 1) == k){
                int currAverage = currSum/k;
                if(currAverage>=threshold)
                    result++;
            }


        }

        return result;
    }
}