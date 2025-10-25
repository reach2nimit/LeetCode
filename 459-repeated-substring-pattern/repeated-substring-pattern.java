class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] prefix = kmpAlgo(s);
        int len = s.length();

        if(prefix[len-1] > 0 && (len % (len - prefix[len-1]) == 0))
            return true;
        
        return false;
    }

    public int[] kmpAlgo(String s){
        int len = s.length();
        int[] prefix = new int[len];
        int left = 0, right = 1;

        while(right < len){

            if(s.charAt(left)==s.charAt(right)){
                prefix[right] = left + 1;
                left++;
                right++;
            }
            else if(left > 0)
                left = prefix[left - 1];
            else
                right++;
        }
        return prefix;
    }
}