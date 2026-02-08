class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)
            return 1;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int currFreq= 1;
        for(int i=1; i<chars.length; i++){
            if(chars[i]==chars[i-1]){
                currFreq++;
            }
            else{
                if(currFreq>1)
                    sb.append(currFreq);
                currFreq = 1;
                sb.append(chars[i]);
            }
        }
        if(currFreq>1)
            sb.append(currFreq);
        System.out.println(sb);
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            System.out.print( ch + " ");
            chars[i] = ch;
        }
        return sb.length();
    }
}