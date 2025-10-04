class Solution {
    public int jump(int[] nums) {
        
        int len = nums.length;
        if(len<=1)
            return 0;
        
        int jump =0, farthest = 0, currEnd = 0;

        for(int i =0; i<len-1; i++){

           farthest = Math.max(farthest, i + nums[i]);

           if(i==currEnd){
            jump++;
            currEnd = farthest;

            if(currEnd >= len - 1){
                break;
            }
           } 
        }
        return jump;
    }
}