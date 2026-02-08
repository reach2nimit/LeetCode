class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0, minCapacity = -1;
        for(int i = 0; i < weights.length; i++){
            totalWeight += weights[i];
            minCapacity = Math.max(weights[i], minCapacity);
        }
        int left = minCapacity; 
        int right = totalWeight;

        while(left <right){

            int mid = left + (right-left)/2;
            int daysNeed = 1, capacity = 0;
            for(int w : weights){
                if(capacity + w > mid){
                    daysNeed++;
                    capacity = w;
                }
                else
                    capacity+=w;
            }

            if(daysNeed<=days)
                right = mid;
            else
                left = mid +1;
        }

        return left;
    }
}