class Solution {

    private static final String [] digitToLetter = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty())
            return result;

        backTrack(result, new StringBuilder(), digits, 0);
        return result;
        
    }

    private void backTrack(List<String> result, StringBuilder currString, String digits, int index){
        if(index==digits.length()){
            result.add(currString.toString());
            return ;
        }

        String letters = digitToLetter[digits.charAt(index) - '0'];

        for(char letter : letters.toCharArray()){
            currString.append(letter);
            backTrack(result, currString, digits, index+1);
            currString.deleteCharAt(currString.length()-1);
        }

    }
}