class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){

            if(ch>='a' && ch<='z')
                sb.append(ch);
            else if(ch>='A' && ch<='Z')
                sb.append((char)('a' + (ch -'A')));
            else if(ch>='0' && ch<='9')
                sb.append(ch); 
        }
        String original = sb.toString();
        String reverseString = sb.reverse().toString();
        System.out.println(original + "    " + reverseString);
        return original.equals(reverseString);
    }
}