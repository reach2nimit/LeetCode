class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length==0) return 0;
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1])); // remember this vimp

        int curr = Integer.MIN_VALUE, result = 0;

        for(int[] pair : pairs){
            if(curr < pair[0]){
                curr = pair[1];
                result++;
            }//think why we are not making result = 0 or finding maxresult here
        }
        return result;
    }
}