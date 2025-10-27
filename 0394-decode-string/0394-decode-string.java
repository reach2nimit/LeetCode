class Solution {
    public String decodeString(String s) {
        String result = "";
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch != ']')
                st.push(ch);
            else{

                StringBuilder sb = new StringBuilder();
                while(st.peek() != '[')
                    sb.append(st.pop());
                st.pop();

                int k = 0, base = 1;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    k = (st.pop() - '0') * base + k;
                    base *= 10;
                }

                while(k>0){
                    for(int i = sb.length()-1; i>=0; i--){
                        st.push(sb.charAt(i));
                    }
                    k--;
                }
            }
        }
        StringBuilder sbb = new StringBuilder();
        while(!st.empty())
            sbb.append(st.pop());
        
        return sbb.reverse().toString();
    }
}