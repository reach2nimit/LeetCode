class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap();
        
        for(String cp : cpdomains){
            String[] parts = cp.split(" ");
            int count = Integer.parseInt(parts[0]);
            String[] fragments = parts[1].split("\\.");
            String subDomain = "";

            for(int i = fragments.length-1; i>=0; i--){
                subDomain = fragments[i] + (subDomain.isEmpty() ? "" : "." + subDomain);
                countMap.put(subDomain, countMap.getOrDefault(subDomain, 0) + count);
            }
        }

        List<String> result = new ArrayList();
        for(Map.Entry<String, Integer> entry : countMap.entrySet())
            result.add( entry.getValue() + " " + entry.getKey());
        return result;
    }
}