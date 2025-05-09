class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for(int num : nums)
            totalSum+=num;

        int leftSum = 0;
        for(int i=0; i<nums.length; i++){
            if((totalSum-leftSum-nums[i]) == leftSum)
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}