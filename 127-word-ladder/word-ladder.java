class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                String currWord = queue.poll();
                char[] wordArray = currWord.toCharArray();

                for(int j=0; j<wordArray.length; j++){

                    char originalChar = wordArray[j];

                    for(char ch = 'a'; ch<='z'; ch++){
                        wordArray[j]=ch;
                        String newWord = new String(wordArray);

                        if(newWord.equals(endWord))
                            return level+1;
                        
                        if(wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordArray[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}