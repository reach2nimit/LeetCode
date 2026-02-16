class Solution {
    public int connectSticks(int[] sticks) {
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        int totalCost = 0;
        for(int stick : sticks)
            pq.add(stick);
        
        while(pq.size()>1){
           int stick1 = pq.remove();
           int stick2 = pq.remove();
           int cost = stick1 + stick2;
           totalCost += cost;
           pq.add(cost); 
        }
        return totalCost;
    }
}