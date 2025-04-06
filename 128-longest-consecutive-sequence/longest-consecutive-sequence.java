class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums)
            numSet.add(num);
        
        int longestStreak = 0;
        for(int num : numSet){

            if(numSet.contains(num-1) == false){
                int currNum = num;
                int currStreak = 1;

                while(numSet.contains(currNum+1) == true){
                    currNum++;
                    currStreak++;
                }

                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;

    }
}