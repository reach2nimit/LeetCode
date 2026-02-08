class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int shift = 0;
        char[] chars = s.toCharArray();
        for(int i = shifts.length-1; i>= 0; i--){
            shift = (shift + shifts[i])%26;
            chars[i] = (char)('a' + (chars[i] - 'a' + shift)%26);
        }

        return new String(chars);
    }
}