class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();

        backTrack(result, new ArrayList(), k, n, 1);
        return result;
        
    }

    private void backTrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int curr){
        if(k==temp.size()){
            result.add(new ArrayList(temp));
            return ;
        }


        for(int  i = curr; i<=n; i++){
            temp.add(i);
            backTrack(result, temp, k, n, i+1);
            temp.remove(temp.size()-1);
        }

    }
}