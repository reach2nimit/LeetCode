class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        backTrack(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void backTrack(int[] nums, ArrayList<Integer> temp, int index, List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        
        
        temp.add(nums[index]);
        backTrack(nums, temp, index+1, result);
        temp.remove(temp.size()-1);
        backTrack(nums, temp, index+1, result);
        return;
    }
}