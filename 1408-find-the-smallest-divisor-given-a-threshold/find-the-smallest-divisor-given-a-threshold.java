class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = -1;
        
        for(int num : nums)
            if(right<num)
                right = num;
        
        while(left < right){
            int mid = left + (right - left)/2;

            if(isFeasible(nums, threshold, mid))
                right = mid;
            else
                left = mid + 1;

        }
        return left;
    }

    public boolean isFeasible(int[] nums, int threshold, int k){
        int count = 0;
        for(int num : nums){
            count+=(num/k);
            if(num%k!=0)
                count++;
        }
        return count<=threshold;
    }
}