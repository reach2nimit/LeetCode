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
    
    void util(TreeNode* r, double t, int &v){
        
        if(!r) return;
        
        
        
    }
    
    int closestValue(TreeNode* root, double target) {
         int val,res = root->val;
        //util(root,target,res);
        
        while(root){
            val = root->val;
            if(abs(target-val) < abs(res-target))
                res = val;
            if(target<root->val)
                root=root->left;
            else
                root=root->right;
        }
        return res;
    }
};