class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num : nums)
            total+=num;
        
        if(total%2!=0)
            return false;
        
        return solveTab(nums, nums.length, total/2);
    }

    //Recursion 
    // public boolean solve(int[] nums, int n, int index, int target){

    //     if(index>=n || target<0)
    //         return false;
    //     if(target==0)
    //         return true;
    //     boolean takeCurrent = solve(nums, n, index+1, target-nums[index]);
    //     boolean skipCurrent = solve(nums, n, index+1, target);

    //     return takeCurrent || skipCurrent;
    // }

    public boolean solveTab(int[] nums, int len, int target){
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                if (dp[i]) continue;
                if (dp[i - n]) dp[i] = true;
                if (dp[target]) return true;
            }
        }

        return false;    
    }
}