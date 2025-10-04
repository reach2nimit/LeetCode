class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if(start>=0 && start<arr.length && arr[start]>=0){

            if(arr[start]==0)
                return true;
            
            int jump = arr[start];
            arr[start] = -arr[start];

            return canReach(arr, start + jump) || canReach(arr, start - jump);
        }

        return false;
    }
}