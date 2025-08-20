class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> freq = new HashMap();
        int left = 0, best = 0;

        for(int right =0; right<fruits.length; right++){
            freq.put(fruits[right], freq.getOrDefault(fruits[right],0) + 1);
            
            while(freq.size()>2){

                freq.put(fruits[left], freq.get(fruits[left]) - 1);

                if(freq.containsKey(fruits[left]) && freq.get(fruits[left]) == 0)
                    freq.remove(fruits[left]);
                
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}