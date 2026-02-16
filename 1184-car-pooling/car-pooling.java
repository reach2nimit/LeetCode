class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] trip = new int[1001];

        for(int i=0; i<trips.length; i++){
            trip[trips[i][1]] += trips[i][0];
            trip[trips[i][2]] -= trips[i][0];
        }

        int currentCapacity = 0;

        for(int i =0; i<1001; i++){
            currentCapacity+=trip[i];
            if(currentCapacity > capacity)
                return false;
        }
        return true;
    }
}