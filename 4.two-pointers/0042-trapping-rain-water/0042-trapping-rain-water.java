class Solution {
    public int trap(int[] height) {

        int left = 0, right = height.length-1;
        int leftMax = height[left], rightMax = height[right];
        int waterStored = 0;
        while(left<right){

            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterStored+=(leftMax - height[left]);
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterStored+=(rightMax - height[right]);
            }
        }
        return waterStored;
    }
}