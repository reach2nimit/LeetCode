class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countMap = new HashMap<>();

        for(String str : strs){

            int[] count = new int[26];

            for(char ch : str.toCharArray())
                count[ch-'a']++;
            
            StringBuilder sb = new StringBuilder();
            for(int num : count)
                sb.append(num).append("#");
            String key = sb.toString();

            if(!countMap.containsKey(key))
                countMap.put(key, new ArrayList<>());
            
            countMap.get(key).add(str);
        }

        return new ArrayList<>(countMap.values());
    }
}