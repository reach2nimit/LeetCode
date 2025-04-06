class Solution {
    public int maxArea(int[] height) {
        
        int left =0, right = height.length - 1;
        int currWaterAmount = 0, result = 0;

        while(left<right){
            if(height[left]<=height[right]){
                currWaterAmount = height[left] * (right - left);
                left++;
            }
            else{
                currWaterAmount = height[right] * (right - left);
                right--;
            }

            result = result > currWaterAmount ? result : currWaterAmount;
        }

        return result;
    }
}