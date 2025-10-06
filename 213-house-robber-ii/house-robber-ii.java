class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        
        int scene1 = robLinear(nums,0,nums.length-2);
        int scene2 = robLinear(nums,1,nums.length-1);

        return Math.max(scene1,scene2);
    }

    public int robLinear(int[] arr, int start, int end){
        int prev1 =0, prev2=0;
        int result = 0;
        for(int i=start; i<=end; i++){
            result = Math.max(prev1, prev2+arr[i]);
            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }
}