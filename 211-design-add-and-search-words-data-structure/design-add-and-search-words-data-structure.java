class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;   
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;

        for(char c : word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index]==null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return searchUtil(0, word.toCharArray(), this.root);
    }

    private boolean searchUtil(int index, char[] charArray, TrieNode node){
        
        if(node == null)
            return false;      
        
        if(index==charArray.length)
            return node.isWord;
       

        char ch = charArray[index]; 
        if(ch=='.'){
            for(TrieNode child : node.children)
                if(child!=null && searchUtil(index + 1, charArray, child))
                    return true;
        }
        else{
            
            int idx = ch - 'a';
            if(node.children[idx] == null)
                return false;

            return searchUtil(index + 1, charArray, node.children[idx]);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */