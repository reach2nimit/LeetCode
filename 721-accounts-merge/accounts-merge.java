class Solution {
    private Map<String, String> owners = new HashMap<>();
    private Map<String, String> parents = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {


        for(List<String> account : accounts){
            String owner = account.get(0);
            for(int i=1; i<account.size(); i++){
                
                String email = account.get(i);
                parents.put(email, email);
                owners.put(email, owner);

            }
        }

        for(List<String> account : accounts){
            String parentNode = find(account.get(1));
            for(int i=2; i<account.size(); i++){
                String currParent = find(account.get(i));
                parents.put(currParent, parentNode);
            }
        }

        Map<String, TreeSet<String>> unions = new HashMap<>();

        for(List<String> account : accounts){
            String currParent = find(account.get(1));
            if(!unions.containsKey(currParent))
                unions.put(currParent, new TreeSet<>());
            
            Set<String> emailSets = unions.get(currParent);
            for(int i =1; i<account.size(); i++)
                emailSets.add(account.get(i));
        }

        List<List<String>> result = new ArrayList<>();

        for(String node : unions.keySet()){
            List<String> emails = new ArrayList(unions.get(node));
            emails.add(0, owners.get(node));
            result.add(emails);

        }
        return result;
    }  
        
    private String find(String node){
        while(!parents.get(node).equals(node)){
            parents.put(node, parents.get(parents.get(node)));
            node = parents.get(node);
        }
        return node;
    }
}

