class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> count = new HashMap();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for(int num : count.keySet()){
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }

        int[] result = new int[k];
        for(int i = 0; i <k ;i ++){
            result[i] = heap.poll();
        }
        return result;
    }
}