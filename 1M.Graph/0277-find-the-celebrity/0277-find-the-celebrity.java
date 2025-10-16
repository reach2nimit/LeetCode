/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {

    private boolean isCelebrity(int celebrity, int n){
        for(int i =0; i<n; i++){
            if(i==celebrity)
                continue;
            
            if(knows(celebrity, i) || !knows(i,celebrity))
                return false;
        }
        return true;
    }
    public int findCelebrity(int n) {
        int celebrity = 0;
        for(int i = 0; i < n; i++){
            if(knows(celebrity, i))
                celebrity = i;
        }
        if(isCelebrity(celebrity, n))
            return celebrity;
       return -1; 
    }
}