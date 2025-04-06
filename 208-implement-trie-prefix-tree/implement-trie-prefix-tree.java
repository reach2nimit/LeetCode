class Trie {
    class TrieNode{
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode(){
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {

        TrieNode curr = this.root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());

            curr = curr.children.get(c);
        }
        
        curr.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {

        TrieNode curr = this.root;

        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */