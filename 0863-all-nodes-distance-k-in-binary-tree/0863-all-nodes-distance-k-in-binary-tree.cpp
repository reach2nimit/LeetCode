/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#define um unordered_map
class Solution {
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        
        um<TreeNode*, TreeNode*> trackParent;
        um<TreeNode*, bool> visited;
        
        queue<TreeNode*> q;
        q.push(root);
        trackParent[root]=NULL;
        while(!q.empty()){
            
            TreeNode* current = q.front();
            q.pop();
            
            if(current->left){
                trackParent[current->left]=current;
                q.push(current->left);
            }
            
            if(current->right){
                trackParent[current->right]=current;
                q.push(current->right);
            }
        }
        
        q.push(target);
        int current_level=0;
        visited[target]=true;
        
        while(!q.empty()){
            
            int qSize = q.size();
         if(current_level++==k)   break;
            
            for(int i=0;i<qSize;i++){
                TreeNode* current = q.front();
                q.pop();
                
                if(current->left && !visited[current->left]){
                    q.push(current->left);
                    visited[current->left]=true;
                }
                
                if(current->right && !visited[current->right]){
                    q.push(current->right);
                    visited[current->right]=true;
                }
                
                if(trackParent[current] && !visited[trackParent[current]]){
                    q.push(trackParent[current]);
                    visited[trackParent[current]]=true;
                }
            }
            
        }
        
        vector<int> res;
        
        while(!q.empty()){
            res.push_back(q.front()->val);
            q.pop();
        }
        return res;
    }
};