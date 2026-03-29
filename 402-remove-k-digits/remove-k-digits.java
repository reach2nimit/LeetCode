class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack();

        for(char ch : num.toCharArray()){

            while(!st.isEmpty() && st.peek() > ch && k>0){
                st.pop();
                k--;
            }
            st.add(ch);
        }
        
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();

        while(sb.length()>0 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);

        return sb.length() > 0 ? sb.toString() : "0";
    }
}