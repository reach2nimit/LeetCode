class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, nums, new ArrayList());
        return result;
        
    }

    private void backTrack(List<List<Integer>> result, int[] nums, List<Integer> temp){

        if(temp.size()==nums.length){
            result.add(new ArrayList(temp));
            return;
        }

        for(int num : nums){
            if(temp.contains(num))
                continue;
            temp.add(num);
            backTrack(result, nums, temp);
            temp.remove(temp.size()-1);
        }
    }
}