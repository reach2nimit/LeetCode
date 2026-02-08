class Solution {

    boolean isFeasible(int[] nums, int k, int h){
        int hours = 0;
        for(int num : nums){
            hours+= (num/k);
            if(num%k!=0) hours++;
        }
        return hours<=h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = -1;
        for(int pile : piles)
            if(right<pile)
                right = pile;
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(piles, mid, h))
                right = mid;
            else
                left = mid + 1;
        }
        return left;

    }
}