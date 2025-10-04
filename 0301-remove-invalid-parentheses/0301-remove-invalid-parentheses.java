class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while(!queue.isEmpty()){
            String current = queue.poll();
            if(isValid(current)){
                result.add(current);
                found = true;
            }

            if(found)
                continue;
            
            for(int i =0; i<current.length(); i++){

                if(current.charAt(i)!='(' && current.charAt(i)!=')')
                    continue;
                
                String next = current.substring(0,i) + current.substring(i+1);

                if(!visited.contains(next)){
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    public boolean isValid(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch=='(')
                count++;
            else if(ch == ')'){
                count--;
                if(count<0)
                    return false;
            }
        }
        return count == 0;
    }
}