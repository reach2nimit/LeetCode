class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0; 
        long windowSum = 0;
        int maxFreq = 1;


        for(int right = 0; right < nums.length; right++){
            windowSum+=nums[right];

            long window = right - left + 1;
            long cost = (long)nums[right] * window - windowSum;

            while(cost > k){
                windowSum-=nums[left];
                left++;
                window = right - left + 1;
                cost = (long)nums[right] * window - windowSum;
            }

            maxFreq = Math.max(maxFreq, (int)window);
        }
        return maxFreq;
    }
}