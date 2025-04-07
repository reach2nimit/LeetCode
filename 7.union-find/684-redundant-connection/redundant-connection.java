class Solution {
    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        parent = new int[len+1];
        rank = new int[len+1];
        for(int i=1; i<len+1; i++)
            parent[i]=i;    

        for(int[] edge : edges){

            if(find(edge[0]) == find(edge[1]))
                return edge;
            
            join(edge[0], edge[1]);
        }

        return new int[0];
    }

    private int find(int i){
        if(parent[i] != i)
            parent[i] = find(parent[i]);
        
        return parent[i];
    }

    private boolean join(int u, int v){
        int parentU = find(u), parentV = find(v);

        if(parentU == parentV)
            return false;
        
        if(rank[parentU]>rank[parentV])
            parent[parentV] = parentU;
        else if(rank[parentU]<rank[parentV])
            parent[parentU] = parentV;
        else{
            parent[parentU] = parentV;
            rank[parentV]++;
        }
        return true;
    }
}