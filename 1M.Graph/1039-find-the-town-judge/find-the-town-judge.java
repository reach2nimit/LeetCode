class Solution {
    public int findJudge(int n, int[][] trust) {
        
       int[] trustRelation = new int[n+1];

        for(int i=0; i<trust.length; i++){
            trustRelation[trust[i][0]]--;
            trustRelation[trust[i][1]]++;
        }

        for(int i=1; i<n+1; i++)
            if(trustRelation[i]==n-1)
                return i;
    
        return -1;
    }
}