class Solution {
    public int connectSticks(int[] sticks) {
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        int totalCost = 0;
        for(int stick : sticks)
            pq.offer(stick);
        
        while(pq.size()>1){
           int stick1 = pq.poll();
           int stick2 = pq.poll();
           int cost = stick1 + stick2;
           totalCost += cost;
           pq.add(cost); 
        }
        return totalCost;
    }
}