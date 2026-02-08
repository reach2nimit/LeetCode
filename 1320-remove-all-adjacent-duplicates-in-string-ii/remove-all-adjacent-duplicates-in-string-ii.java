class Solution {
    private static class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque();

        for(char ch : s.toCharArray()){

            if(!stack.isEmpty() && stack.peek().ch == ch){
                stack.peek().freq++;
                if(stack.peek().freq == k)
                    stack.pop();
            }
            else{
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            for(int i = 0; i<p.freq; i++)
                sb.append(p.ch);
        }

        return sb.reverse().toString();
    }
}