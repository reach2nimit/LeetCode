class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = buildTrie(words);
        List<String> result = new ArrayList<>();

        for(int i=0; i<board.length;i++){
            for(int j = 0; j<board[0].length; j++){
                dfs(board, i, j, trie, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, Trie root, List<String> result){

        char ch = board[i][j];

        if(ch == '#' || root.children[ch - 'a'] == null)
            return;

        root = root.children[ch - 'a'];

        if(root.word != null){
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '#';

        if(i>0) dfs(board, i-1, j, root, result);
        if(j>0) dfs(board, i, j-1, root, result);

        if(i<board.length-1) dfs(board, i+1, j, root, result);
        if(j<board[0].length-1) dfs(board, i, j+1, root, result);

        board[i][j] = ch;

        return;
    }

    private Trie buildTrie(String[] words){
        Trie root = new Trie();
        for(String word : words){
            Trie temp = root;
            for(char ch : word.toCharArray()){
                
                if(temp.children[ch-'a'] == null)
                    temp.children[ch - 'a'] = new Trie();
                
                temp = temp.children[ch - 'a'];
            }
            temp.word = word;
        }

        return root;
    }
    private class Trie{
        Trie[] children = new Trie[26];
        String word = null;
    }
}