class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(current, s, 0, result);
        return result;
    }

    public void backtrack(List<String> current, String s, int start,  List<List<String>> result){

        if(start>=s.length()){
            result.add(new ArrayList<String>(current));
            return;
        }

        for(int end = start; end < s.length(); end++){

            if(isPalindrome(s, start,end)){
                current.add(s.substring(start, end+1));
                backtrack(current, s, end+1, result);
                current.remove(current.size()-1);
            }

        }

    }

    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}