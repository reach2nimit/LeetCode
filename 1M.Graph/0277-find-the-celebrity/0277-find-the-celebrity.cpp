/* The knows API is defined for you.
      bool knows(int a, int b); */

class Solution {
public:
    int findCelebrity(int n) {
        
        int celebrity =0;
        
        for(int i=0; i<n; i++){
            
            if(knows(celebrity,i))
                celebrity = i;
        }
        
        if(isCelebrity(celebrity, n))
            return celebrity;
        
        return -1;
    }
    
    bool isCelebrity(int celebrity, int n){
        
        for(int i=0; i<n; i++){
            
            if(i==celebrity) continue;
            
            if(!knows(i, celebrity) || knows(celebrity,i))
                return false;
        }
        return true;
    }
};