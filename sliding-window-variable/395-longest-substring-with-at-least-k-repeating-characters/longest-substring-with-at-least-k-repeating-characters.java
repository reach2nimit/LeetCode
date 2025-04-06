class Solution {
    private int getUniqueCount(String s){
        boolean[] chars = new boolean[26];
        int count = 0;

        for(char ch : s.toCharArray()){
            int idx = ch - 'a';

            if(!chars[idx]){
                count++;
                chars[idx]=true;
            }
        }
        return count;
    }

    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        int result =0;
        int uniqueCount = getUniqueCount(s);

        for(int currUniqueCount = 1; currUniqueCount<= uniqueCount; currUniqueCount++){
            Arrays.fill(freq, 0);

            int currCount =0, countAtLeastK =0;
            int start = 0, end =0;

            while(end<s.length()){

                if(currCount<=currUniqueCount){
                    int idx = s.charAt(end) - 'a';
                    if(freq[idx]==0)
                        currCount++;
                    freq[idx]++;

                    if(freq[idx]==k)
                        countAtLeastK++;

                    end++;
                } else{

                    int idx = s.charAt(start) - 'a';

                    if(freq[idx] == k)
                        countAtLeastK--;
                    
                    freq[idx]--;

                    if(freq[idx]==0)
                        currCount--;
                    
                    start++;
                }

                if(currCount == currUniqueCount && currCount == countAtLeastK )
                    result = Math.max(result, end - start );
            }
        }
    

        return result;
    }
}