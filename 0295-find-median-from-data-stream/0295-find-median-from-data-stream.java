class MedianFinder {
    PriorityQueue<Integer> lowerhalf;
    PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerhalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lowerhalf.isEmpty() || lowerhalf.peek() >= num)
            lowerhalf.offer(num);
        else
            upperHalf.offer(num);
        
        if(lowerhalf.size() > upperHalf.size() + 1)
            upperHalf.offer(lowerhalf.poll());
        else if ( lowerhalf.size() < upperHalf.size())
            lowerhalf.offer(upperHalf.poll());
    }
    
    public double findMedian() {
        if(lowerhalf.size() > upperHalf.size())
            return lowerhalf.peek();
        
        return (lowerhalf.peek() + upperHalf.peek())/2.0 ;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */