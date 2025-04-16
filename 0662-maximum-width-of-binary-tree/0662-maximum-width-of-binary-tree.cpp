class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
    
        queue<pair<TreeNode*,int>> q;
        q.push({root,0});
        int ans = 0;
        
        while(!q.empty()){
            
            int lastNode=0,firstNode=0;
            int minVal = q.front().second;
            int qSize =  q.size();
            for(int i=0;i<qSize;i++){
                TreeNode* current = q.front().first;
                int currentVal = q.front().second - minVal;
                q.pop();
                
                if(i==0)
                    firstNode = currentVal;
                
                if(i==qSize-1)
                    lastNode = currentVal;
                
                if(current->left)
                    q.push({current->left, 2*currentVal+1});
                
                if(current->right)
                    q.push({current->right,2*currentVal+2});
            }
            ans = max(ans,lastNode-firstNode+1);
        }
        return ans;
    }
};
