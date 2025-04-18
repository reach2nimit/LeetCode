/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    int kthSmallest(TreeNode* root, int k) {
        
       if(!root) 
            return -1;
        
       stack<TreeNode*> s;
       TreeNode* temp=root; 
       while(!s.empty() || temp){
         
           while(temp){
               s.push(temp);
               temp=temp->left;
           }
           temp = s.top();
           s.pop();
           k--;
           if(k==0)
               return temp->val;
           temp = temp->right;
           
       } 
        return -1;  
    }
};