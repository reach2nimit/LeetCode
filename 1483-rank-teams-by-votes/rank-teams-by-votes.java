class Solution {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] map = new int[26][len+1];

        for(int i=0; i<26; i++)
            map[i][len]=i;
        
        for(int i=0; i<votes.length; i++){
            String str = votes[i];
            for(int j=0; j<len; j++){
                map[str.charAt(j) - 'A'][j]++;
            }
        }

        Arrays.sort(map, (a,b) -> {
            for(int i=0; i<len; i++){
                if(a[i]<b[i])
                    return 1;
                if(a[i]>b[i])
                    return -1;
            }
            return a[len]-b[len];
        });
        
        StringBuilder result = new StringBuilder();
        for(int i=0; i<len; i++)
            result.append((char)('A' + map[i][len]));
        
        return result.toString();
    }
}