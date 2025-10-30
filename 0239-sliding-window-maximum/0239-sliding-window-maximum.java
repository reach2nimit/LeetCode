class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for(int i =0; i<k ; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offerLast(i);
        }
        result[index] = nums[dq.peekFirst()];
        index++;

        for(int i = k ;i <nums.length; i++){
            if(dq.peekFirst() == i - k)
                dq.pollFirst();
            
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            
            dq.offerLast(i);
            result[index] = nums[dq.peekFirst()];
            index++;

        }

        return result;
    }
}