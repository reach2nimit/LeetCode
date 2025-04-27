class Solution {

    enum Color{
        WHITE, GREY, BLACK
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList());
        
        for(int[] preq : prerequisites){
            graph.get(preq[0]).add(preq[1]);
        }

        Color[] visited = new Color[numCourses];
        for(int i=0; i<numCourses; i++)
            visited[i]=Color.WHITE;

        for(int i=0; i<numCourses; i++){

            if(visited[i]==Color.WHITE && !isCyclic(i, visited, graph))
                return false;
        }
        return true;
    }

    private boolean isCyclic(int node, Color[] visited, List<List<Integer>> graph){

        visited[node]=Color.GREY;

        for(int i : graph.get(node)){

            if(visited[i]==Color.GREY)
                return false;
            
            if(visited[i]==Color.WHITE && !isCyclic(i, visited, graph))
                return false; 
        }

        visited[node]=Color.BLACK;
        return true;
    }
}