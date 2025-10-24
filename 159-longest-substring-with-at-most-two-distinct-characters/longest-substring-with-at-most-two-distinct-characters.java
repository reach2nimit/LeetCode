class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int k = 2;
        int left = 0, right =0;
        int[] count = new int[128];
        int maxLen = 0, unique = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            
            if(count[ch]==0)
                unique++;
            
            count[ch]++;

            if(unique>k){
                while(unique > k){
                    char ch2 = s.charAt(left);
                    count[ch2]--;
                    if(count[ch2]==0)
                        unique--;
                    left++;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}