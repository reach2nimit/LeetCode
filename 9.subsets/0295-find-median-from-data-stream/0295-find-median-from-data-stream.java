class MedianFinder {

    
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
        
    }
    
    public double findMedian() {
        
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        
        return (maxHeap.peek() + minHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */