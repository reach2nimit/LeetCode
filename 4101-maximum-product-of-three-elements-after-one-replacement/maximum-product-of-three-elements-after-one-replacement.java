class Solution {
    public long maxProduct(int[] nums) {
        long maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE;
        long minP = Integer.MAX_VALUE, minQ = Integer.MAX_VALUE; 
        int countNonZero = 0;
        
        for(int num : nums){
            if(num != 0){
                countNonZero++;
            }
            
            // Track two largest
            if(num >= maxA){
                maxB = maxA;
                maxA = num;
            }
            else if(num >= maxB)
                maxB = num;

            // Track two smallest
            if(num <= minP){
                minQ = minP;
                minP = num;
            }
            else if(num <= minQ)  // ✅ FIXED: Changed >= to <=
                minQ = num;
        }
        
        if(countNonZero <2){  
            return 0;
        }
        
        long result = 0;
        result = Math.max(result, maxA * maxB * 100000);
        result = Math.max(result, minP * minQ * 100000);
        result = Math.max(result, maxA * minP * -100000);
        return result;
    }
}