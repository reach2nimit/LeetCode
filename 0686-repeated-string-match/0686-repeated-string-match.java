class Solution {
    public int repeatedStringMatch(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        int repeat = (len2+len1 -1)/len1;

        StringBuilder sb = new StringBuilder(a);
        for(int k = 1; k<repeat; k++){
            sb.append(a);
        }

        if(searchString(sb.toString(), b))
            return repeat;
        
        sb.append(a);
        repeat++;
        if(searchString(sb.toString(), b))
            return repeat;
        return -1;
    }

    public boolean searchString(String text, String pattern){
        int[] prefix = computeLPS(pattern);

        int i = 0, j = 0;

        while(i < text.length()){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                if(j == pattern.length())
                    return true;
            }
            else if( j > 0)
                j = prefix[j-1];
            else
                i++;
        }
        return false;
    }

    public int[] computeLPS(String pattern){
        int len = pattern.length();
        int[] prefix = new int[len];

        int left = 0, right = 1;
        while(right < len){
            if(pattern.charAt(left) == pattern.charAt(right)){
                prefix[right] = left + 1;
                left++;
                right++;
            }
            else if(left>0)
                left = prefix[left - 1];
            else
                right++;
        }

        return prefix;
    }
}