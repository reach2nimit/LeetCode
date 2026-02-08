class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if( m > (bloomDay.length/k) )
            return -1;

        int left = 1, right = -1;

        for(int bloom : bloomDay){
            if(right<bloom)
                right = bloom;
            // if(left >bloom)
            //     left = bloom;
        }
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(bloomDay,m,k,mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public boolean isFeasible(int[] bloomDays, int m , int k, int day){
        int flowers = 0, bouquets = 0;
        for(int bloom : bloomDays){
            if(bloom<=day){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers=0;
                }
            }
            else
                flowers= 0;
        }
        return bouquets >= m;
    }
}