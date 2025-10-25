class Solution {
    private
        List<List<String>> ans;
    public List<List<String>> partition(String s) {
        
        ans = new ArrayList<>();
        List<String> curr = new ArrayList();
        dfs(curr, s, 0);
        return ans;
        
    }
    
    public void dfs(List<String> curr, String s, int start){
        
        if(start>=s.length())
            ans.add(new ArrayList<String>(curr));
           
        for(int end = start; end<s.length(); end++){
            
            if(isPalind(start,end,s)){
                curr.add(s.substring(start,end+1));
                dfs(curr, s, end+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalind(int i, int j, String s){
        
        while(i<j)
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        return true;
    }
}