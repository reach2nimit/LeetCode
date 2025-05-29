class StockPrice {
    private final Map<Integer, Integer> timestampPriceMap;
    private final TreeMap<Integer, Integer> priceFreq;
    private int currentTimestamp;

    public StockPrice() {
        timestampPriceMap = new HashMap<>();
        priceFreq = new TreeMap<>();
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

        if (timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
        }  
    }
    
    public int current() {
        return timestampPriceMap.get(currentTimestamp);
        
    }
    
    public int maximum() {
        return priceFreq.lastKey();
    }
    
    public int minimum() {
        return priceFreq.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */