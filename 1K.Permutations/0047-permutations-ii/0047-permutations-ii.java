class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, nums, new ArrayList(), new boolean[nums.length]);
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, List<Integer> temp, boolean[] visited){

        if(temp.size()==nums.length){
            result.add(new ArrayList(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1]))
                continue;
            temp.add(nums[i]);
            visited[i]=true;
            backTrack(result, nums, temp, visited);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}