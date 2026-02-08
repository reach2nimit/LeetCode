class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(); 
        int right = Arrays.stream(weights).sum();

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