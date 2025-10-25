class Solution {
    private int index =0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList());
        
        for(int[] preq : prerequisites)
            graph.get(preq[0]).add(preq[1]);
        
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
 
        for(int i=0; i<numCourses; i++){
            if(visited[i]==0 && !isCyclic(visited, graph, i, result))
                return new int[0];
        }

        return result;
    }

    private boolean isCyclic(int[] visited, List<List<Integer>> graph, 
                             int node, int[] result) {
        
        visited[node]=1;

        for(int i : graph.get(node)){

            if(visited[i]==1)
                return false;
            
            if(visited[i]==0 && !isCyclic(visited, graph, i, result))
                return false;

        }

        visited[node]=2;
        result[index]=node;
        index++;
        return true;
    }
}