class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int lenS = s.length(), lenP = p.length();

        if(lenP>lenS)
            return result;
        
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(char ch : p.toCharArray())
            pCount[ch - 'a']++;
        
        for(int i=0; i<lenS; i++) {
            char ch = s.charAt(i);
            sCount[ch - 'a']++;

            if(i >= lenP){
                sCount[s.charAt(i - lenP) - 'a']--;
            }
            if(Arrays.equals(sCount, pCount))
                result.add(i - lenP + 1);
        }
        
        return result;
    }
}