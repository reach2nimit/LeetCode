class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        
        int[] map = new int[128];
        for(char ch : t.toCharArray())
            map[ch]++;
        
        int count = t.length();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int minIndex = 0;

        while(end < s.length()){

            char ch = s.charAt(end);
            if(map[ch]>0)
                count--;
            end++;
            map[ch]--;

            while(count == 0){

                if(minLen > end - start){
                    minLen = end - start;
                    minIndex = start;
                }

                char startChar = s.charAt(start);
                map[startChar]++;

                if(map[startChar] > 0)
                    count++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :s.substring(minIndex, minIndex + minLen);
    }
}