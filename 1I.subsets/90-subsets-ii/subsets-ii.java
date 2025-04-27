class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        subset2( 0, nums, new ArrayList<>(), result);
        return result;
    }

    private void subset2(int index, int[] nums, List<Integer> temp, List<List<Integer>> result){

        result.add(new ArrayList<>(temp));

        for(int i = index; i<nums.length; i++){

            if(i>index && nums[i]==nums[i-1])
                continue;
            
            temp.add(nums[i]);
            subset2(i+1, nums, temp, result);
            temp.remove(temp.size()-1);
        }

    }

}