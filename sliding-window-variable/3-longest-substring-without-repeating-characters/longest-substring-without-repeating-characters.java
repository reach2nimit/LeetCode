class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left =0, right =0, result =0;
        int[] seen = new int[128];

        while(right<s.length()){
            char curr = s.charAt(right);
            seen[curr]++;

            while(seen[curr]>1 && left <s.length()){
                seen[s.charAt(left)]--;
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}