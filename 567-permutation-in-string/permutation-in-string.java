class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        
        int[] s1Char = new int[128];
        int[] s2Char = new int[128];

        for(int i = 0; i<s1.length(); i++)
            s1Char[s1.charAt(i)]++;

        for(int i = 0; i < s2.length(); i++){
            s2Char[s2.charAt(i)]++;

            if(i>=s1.length() - 1){
                if(Arrays.equals(s1Char, s2Char))
                    return true;
                s2Char[s2.charAt(i - s1.length() + 1)]--;
            }
        } 
        return false;  
    }
}