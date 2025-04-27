class Solution {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visited; 
    private List<Character> result;
    
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for(String word : words){
            for(char ch : word.toCharArray())
                adj.putIfAbsent(ch, new HashSet<>());
        }

        for(int i=0; i<words.length-1; i++){
            String w1 = words[i], w2= words[i+1];

            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && 
               w1.substring(0, minLen).equals(w2.substring(0, minLen)))
               return "";

            for(int j=0; j<minLen; j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap();
        result = new ArrayList();

        for(char ch : adj.keySet()){
            if(dfs(ch))
                return "";
        }

        Collections.reverse(result);

        StringBuilder str = new StringBuilder();
        for(char c : result)
            str.append(c);

        return str.toString();    

    }

    private boolean dfs(char ch){
        if(visited.containsKey(ch))
            return visited.get(ch);
        
        visited.put(ch, true);
        for(char next : adj.get(ch))
            if(dfs(next))
                return true;

        visited.put(ch, false);
        result.add(ch);
        return false;
    }
}