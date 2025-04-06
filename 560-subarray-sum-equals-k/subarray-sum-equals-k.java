class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0,1);
        int currSum = 0, currCount=0;
        
        for(int num: nums){

            currSum+=num;
            if(sumCount.containsKey(currSum-k))
                currCount+=sumCount.get(currSum-k);

            sumCount.put(currSum, sumCount.getOrDefault(currSum, 0) + 1);

        }

        return currCount;
    }
}