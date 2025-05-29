class StockPrice {
    private final Map<Integer, Integer> timestampPriceMap;
    private final Map<Integer, Integer> priceFreq;
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;
    private int currentTimestamp;

    public StockPrice() {
        timestampPriceMap = new HashMap<>();
        priceFreq = new HashMap<>();
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        currentTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        if (timestampPriceMap.containsKey(timestamp)) {
            int oldPrice = timestampPriceMap.get(timestamp);
            int count = priceFreq.get(oldPrice);
            if (count == 1) {
                priceFreq.remove(oldPrice);
            } else {
                priceFreq.put(oldPrice, count - 1);
            }
        }

        timestampPriceMap.put(timestamp, price);
        priceFreq.put(price, priceFreq.getOrDefault(price, 0) + 1);
        minHeap.offer(price);
        maxHeap.offer(price);

        if (timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
        }
    }

    public int current() {
        return timestampPriceMap.get(currentTimestamp);
    }

    public int maximum() {
        while (!maxHeap.isEmpty() && priceFreq.getOrDefault(maxHeap.peek(), 0) == 0) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public int minimum() {
        while (!minHeap.isEmpty() && priceFreq.getOrDefault(minHeap.peek(), 0) == 0) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
} 