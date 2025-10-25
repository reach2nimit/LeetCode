class Solution {

    enum Color{
        WHITE, GREY, BLACK;
    }
    private int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
  List<List<Integer>>  schedule = new ArrayList<>();
       for(int i = 0; i<numCourses; i++)
        schedule.add(new ArrayList<>());
       for(int[] preq : prerequisites)
        schedule.get(preq[0]).add(preq[1]);

       Color[] visited = new Color[numCourses];
       int[] order = new int[numCourses];
       for(int i = 0; i<numCourses; i++)
        visited[i]=Color.WHITE;
    
       for(int i=0; i<numCourses; i++){

        if(visited[i] == Color.WHITE && isCyclic(visited, schedule, i, order))
            return new int[0];
       }
       return order;
    }

    public boolean isCyclic(Color[] visited,  List<List<Integer>>  schedule, int node, int[] order) {
        visited[node]=Color.GREY;

        for(int i : schedule.get(node)){

            if(visited[i]==Color.GREY)
                return true;
            
            if(visited[i]==Color.WHITE && isCyclic(visited, schedule, i, order))
                return true;
        }
        visited[node]=Color.BLACK;
        order[index] = node;
        index++;
        return false;
    }
}