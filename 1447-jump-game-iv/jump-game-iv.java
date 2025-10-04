class Solution {
    public int minJumps(int[] arr) {
        int len = arr.length;
        if(len<=1)
            return 0;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i<len; i++){
            if(!graph.containsKey(arr[i])){
                graph.put(arr[i], new ArrayList<>());
            }
            graph.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet();

        q.offer(0);
        visited.add(0);
        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i =0; i<size; i++){

                int currIndex = q.poll();

                if(currIndex == len-1)
                    return steps;
                
                List<Integer> neighbours = new ArrayList();

                if(currIndex - 1 >=0)
                    neighbours.add(currIndex-1);
                
                if(currIndex + 1 < len)
                    neighbours.add(currIndex + 1);
                
                if(graph.containsKey(arr[currIndex])){
                    neighbours.addAll(graph.get(arr[currIndex]));
                    graph.remove(arr[currIndex]);
                }

                for(int neighbour : neighbours){
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        q.offer(neighbour);
                    }
                }
            }

            steps++;
        }

    return -1;

    }

}